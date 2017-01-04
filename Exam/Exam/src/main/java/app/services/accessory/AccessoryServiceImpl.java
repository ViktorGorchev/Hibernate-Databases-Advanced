package app.services.accessory;

import app.domain.dto.xmlImport.accessories.AccessoryImportXmlDto;
import app.domain.models.Accessory;
import app.domain.models.Photographer;
import app.parsers.modelParser.ModelParser;
import app.repositories.AccessoryRepository;
import app.repositories.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class AccessoryServiceImpl implements AccessoryService {

	@Autowired
	private AccessoryRepository accessoryRepository;

    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(AccessoryImportXmlDto accessoryImportXmlDto) {
        Accessory accessory = this.modelParser.convert(accessoryImportXmlDto, Accessory.class);
        accessory.setOwner(this.randomOwner());
        this.accessoryRepository.saveAndFlush(accessory);
    }

    private Photographer randomOwner(){
        Long randomId = ThreadLocalRandom.current().nextLong(1, this.photographerRepository.count() + 1);
        Photographer photographer = this.photographerRepository.findOne(randomId);

        return photographer;
    }
}