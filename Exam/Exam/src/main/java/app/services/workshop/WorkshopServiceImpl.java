package app.services.workshop;

import app.domain.dto.xmlImport.workshop.PhotographerXmlDto;
import app.domain.dto.xmlImport.workshop.WorkshopXmlDto;
import app.domain.models.Photographer;
import app.domain.models.Workshop;
import app.parsers.modelParser.ModelParser;
import app.repositories.PhotographerRepository;
import app.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class WorkshopServiceImpl implements WorkshopService {

	@Autowired
	private WorkshopRepository workshopRepository;

    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(WorkshopXmlDto workshopXmlDto) {
        Workshop workshop = this.modelParser.convert(workshopXmlDto, Workshop.class);

        String[] trainerNames = workshopXmlDto.getTrainerFullName().trim().split("\\s+");
        String trainerFirstName = trainerNames[0].trim();
        String trainerLastName = trainerNames[1].trim();
        Photographer trainer =
                this.photographerRepository.findByFirstNameAndLastName(trainerFirstName, trainerLastName);
        workshop.setTrainer(trainer);

        Set<Photographer> participants = new HashSet<>();
        for (PhotographerXmlDto photographerXmlDto : workshopXmlDto.getParticipants()) {
            Photographer participant =
                    this.photographerRepository.findByFirstNameAndLastName(
                            photographerXmlDto.getFirstName(),
                            photographerXmlDto.getLastName()
                    );

            participants.add(participant);
        }

        for (Photographer participant : participants) {
            participant.getParticipatingInWorkshops().add(workshop);
        }

        workshop.setParticipants(participants);

        this.workshopRepository.saveAndFlush(workshop);
    }
}