package app.services.photographer;

import app.domain.dto.jsonExport.LandscapePhotographerExportDto;
import app.domain.dto.jsonExport.PhotographerExportDto;
import app.domain.dto.jsonImport.PhotographerImportDto;
import app.domain.models.Lens;
import app.domain.models.Photographer;
import app.domain.models.camera.BasicCamera;
import app.parsers.modelParser.ModelParser;
import app.repositories.BasicCameraRepository;
import app.repositories.LensRepository;
import app.repositories.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class PhotographerServiceImpl implements PhotographerService {

	@Autowired
	private PhotographerRepository photographerRepository;

    @Autowired
    private BasicCameraRepository basicCameraRepository;

    @Autowired
    private LensRepository lensRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public String create(PhotographerImportDto photographerImportDto) {
        BasicCamera primaryCamera = this.randomCamera();
        BasicCamera secondaryCamera = this.randomCamera();
        Set<Lens> lenses = this.getLenses(photographerImportDto.getLenses(), primaryCamera, secondaryCamera);

        Photographer photographer = this.modelParser.convert(photographerImportDto, Photographer.class);
        photographer.setPrimaryCamera(primaryCamera);
        photographer.setSecondaryCamera(secondaryCamera);
        for (Lens lens : lenses) {
            lens.setOwner(photographer);
        }

        photographer.setLenses(lenses);

        this.photographerRepository.saveAndFlush(photographer);

        String result = String.format(
                "Successfully imported %s %s | Lenses: %d",
                photographer.getFirstName(),
                photographer.getLastName(),
                lenses.size()
        );

        return result;
    }

    @Override
    public List<PhotographerExportDto> findAllPhotographersOrdered() {
        List<Photographer> photographers = this.photographerRepository.findAllOrderByFirstNameAscLastNameDesc();
        List<PhotographerExportDto> photographerExportDtos =
                this.modelParser.convert(photographers, PhotographerExportDto.class);

        return photographerExportDtos;
    }

    @Override
    public List<LandscapePhotographerExportDto> findAllLandscapePhotographers() {
        List<Object[]> photographersData = this.photographerRepository.findLandscapePhotographers();
        List<LandscapePhotographerExportDto> landscapePhotographerDtos = new ArrayList<>();
        for (Object[] objects : photographersData) {
            String firstName = String.valueOf(objects[0]);
            String lastName = String.valueOf(objects[1]);
            String cameraMake = String.valueOf(objects[2]);
            BigInteger lensesCount = new BigInteger(String.valueOf(objects[3]));

            LandscapePhotographerExportDto photographerDto = new LandscapePhotographerExportDto();
            photographerDto.setFirstName(firstName);
            photographerDto.setLastName(lastName);
            photographerDto.setCameraMake(cameraMake);
            photographerDto.setLensesCount(lensesCount);

            landscapePhotographerDtos.add(photographerDto);
        }

        return landscapePhotographerDtos;
    }

    private Set<Lens> getLenses(List<Long> lenses, BasicCamera primaryCamera, BasicCamera secondaryCamera) {
        Set<Lens> validLenses = new HashSet<>();
        for (Long lens : lenses) {
            Lens lensInDB = this.lensRepository.findOne(lens);
            if(lensInDB == null){
                continue;
            }

            if(! lensInDB.getCompatibleWith().equals(primaryCamera.getMake()) &&
                    ! lensInDB.getCompatibleWith().equals(secondaryCamera.getMake())){
                continue;
            }

            validLenses.add(lensInDB);
        }

        return validLenses;
    }

    private BasicCamera randomCamera(){
        Long randomCameraId = ThreadLocalRandom.current().nextLong(1, this.basicCameraRepository.count() + 1);
        BasicCamera camera = this.basicCameraRepository.findOne(randomCameraId);

        return camera;
    }
}