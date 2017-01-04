package app.terminal;

import app.domain.dto.jsonExport.LandscapePhotographerExportDto;
import app.domain.dto.jsonExport.PhotographerExportDto;
import app.domain.dto.jsonImport.BasicCameraImportDto;
import app.domain.dto.jsonImport.LensImportJsonDto;
import app.domain.dto.jsonImport.PhotographerImportDto;
import app.domain.dto.xmlImport.accessories.AccessoriesImportXmlDto;
import app.domain.dto.xmlImport.accessories.AccessoryImportXmlDto;
import app.domain.dto.xmlImport.workshop.WorkshopXmlDto;
import app.domain.dto.xmlImport.workshop.WorkshopsXmlDto;
import app.parsers.jsonParser.JsonParser;
import app.parsers.xmlParser.XMLParser;
import app.services.accessory.AccessoryService;
import app.services.basicCamera.BasicCameraService;
import app.services.lens.LensService;
import app.services.photographer.PhotographerService;
import app.services.workshop.WorkshopService;
import app.ui.Renderer;
import app.validator.DtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private Renderer renderer;

    @Autowired
    private AccessoryService accessoryService;

    @Autowired
    private BasicCameraService basicCameraService;

    @Autowired
    private LensService lensService;

    @Autowired
    private PhotographerService photographerService;

    @Autowired
    private WorkshopService workshopService;

    @Autowired
    private JsonParser jsonParser;

    @Autowired
    private XMLParser xmlParser;

    @Autowired
    private DtoValidator dtoValidator;

    @Override
    public void run(String... strings) throws Exception {
        this.seedLenses();
        this.seedCameras();
        this.seedPhotographers();
        this.seedAccessories();
        this.seedWorkshops();

        this.exportOrderedPhotographersJson();
        this.exportLandscapePhotographersJson();
    }

    private void exportLandscapePhotographersJson() {
        List<LandscapePhotographerExportDto> photographerDtos =
                this.photographerService.findAllLandscapePhotographers();

        try {
            this.jsonParser.exportJson(
                    photographerDtos,
                    "src/main/resources/files/output/json/landscape-photographers.json"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportOrderedPhotographersJson() {
        List<PhotographerExportDto> photographerDtos = this.photographerService.findAllPhotographersOrdered();

        try {
            this.jsonParser.exportJson(
                    photographerDtos,
                    "src/main/resources/files/output/json/photographers-ordered.json"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedWorkshops() {
        WorkshopsXmlDto workshopsXmlDto = null;
        try {
            workshopsXmlDto = this.xmlParser.read(WorkshopsXmlDto.class, "/files/input/xml/workshops.xml");

            int a = 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for (WorkshopXmlDto workshopXmlDto : workshopsXmlDto.getWorkshopXmlDtos()) {
            if(! this.dtoValidator.isValid(workshopXmlDto)){
                this.renderer.render("Error. Invalid data provided");
                continue;
            }

            this.workshopService.create(workshopXmlDto);
            this.renderer.render(String.format(
                    "Successfully imported %s",
                    workshopXmlDto.getName()
            ));
        }
    }

    private void seedAccessories() {
        AccessoriesImportXmlDto accessoriesDtos = null;
        try {
            accessoriesDtos = this.xmlParser.read(AccessoriesImportXmlDto.class, "/files/input/xml/accessories.xml");
        } catch (IOException e) {
            e.printStackTrace();
            this.renderer.render(e.getMessage());
        } catch (JAXBException e) {
            e.printStackTrace();
            this.renderer.render(e.getMessage());
        }

        for (AccessoryImportXmlDto accessoryDto : accessoriesDtos.getAccessoryImportXmlDtos()) {
            this.accessoryService.create(accessoryDto);
            this.renderer.render("Successfully imported " + accessoryDto.getName());
        }
    }

    private void seedPhotographers() {
        PhotographerImportDto[] photographersDtos = null;
        try {
            photographersDtos =
                    this.jsonParser.importJson(PhotographerImportDto[].class, "/files/input/json/photographers.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (PhotographerImportDto photographersDto : photographersDtos) {
            if(! this.dtoValidator.isValid(photographersDto)){
                this.renderer.render("Error. Invalid data provided");
                continue;
            }

            String operationResult = this.photographerService.create(photographersDto);
            this.renderer.render(operationResult);
        }
    }

    private void seedCameras() {
        BasicCameraImportDto[] cameraDtos = null;
        try {
            cameraDtos = this.jsonParser.importJson(BasicCameraImportDto[].class, "/files/input/json/cameras.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (BasicCameraImportDto cameraDto : cameraDtos) {
            if(! this.dtoValidator.isValid(cameraDto)){
                this.renderer.render("Error. Invalid data provided");
                continue;
            }

            this.basicCameraService.create(cameraDto);
            this.renderer.render(String.format(
                    "Successfully imported %s %s %s",
                    cameraDto.getType(),
                    cameraDto.getMake(),
                    cameraDto.getModel()
            ));
        }
    }

    private void seedLenses() {
        LensImportJsonDto[] lensDtos = null;

        try {
            lensDtos = this.jsonParser.importJson(LensImportJsonDto[].class, "/files/input/json/lenses.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (LensImportJsonDto lensDto : lensDtos) {
            try {
                this.lensService.create(lensDto);
            }catch (ValidationException ve){
                ve.printStackTrace();
            }

            this.renderer.render(String.format(
                    "Successfully imported %s %dmm f%.1f",
                    lensDto.getMake(),
                    lensDto.getFocalLength(),
                    lensDto.getMaxAperture()
            ));
        }
    }
}
