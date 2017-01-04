package app.services.basicCamera;

import app.domain.dto.jsonImport.BasicCameraImportDto;
import app.domain.models.camera.BasicCamera;
import app.domain.models.camera.DSLRCamera;
import app.domain.models.camera.MirrorlessCamera;
import app.parsers.modelParser.ModelParser;
import app.repositories.BasicCameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BasicCameraServiceImpl implements BasicCameraService {

	@Autowired
	private BasicCameraRepository basicCameraRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(BasicCameraImportDto basicCameraImportDto) {
        BasicCamera camera = this.cameraFactory(basicCameraImportDto);
        this.basicCameraRepository.saveAndFlush(camera);
    }

    private BasicCamera cameraFactory(BasicCameraImportDto basicCameraImportDto) {
        BasicCamera camera = null;

        switch (basicCameraImportDto.getType()){
            case "DSLR":
                camera = this.modelParser.convert(basicCameraImportDto, DSLRCamera.class);
                break;
            case "Mirrorless":
                camera = this.modelParser.convert(basicCameraImportDto, MirrorlessCamera.class);
                break;
            default:
                break;
        }

        return camera;
    }
}