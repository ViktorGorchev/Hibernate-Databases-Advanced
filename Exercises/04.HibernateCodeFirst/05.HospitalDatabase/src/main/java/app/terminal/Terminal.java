package app.terminal;

import app.domain.Diagnose;
import app.domain.Medicament;
import app.domain.Patient;
import app.domain.Visitation;
import app.services.DiagnoseService;
import app.services.MedicamentService;
import app.services.PatientService;
import app.services.VisitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private DiagnoseService diagnoseService;

    @Autowired
    private MedicamentService medicamentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitationService visitationService;

    @Override
    public void run(String... strings) throws Exception {
        File picture = new File("res/smallpic.jpg");
        byte[] pictureBytes = new byte[(int) picture.length()];
        FileInputStream fis = new FileInputStream(picture);
        fis.read(pictureBytes);
        fis.close();

        Patient pesho = new Patient("Pesho", "Goshov", "Sofia, Tintiava 2", "pesho@abv.bg", new Date(), pictureBytes);
        Diagnose diagnose = new Diagnose("headache", "no comments", pesho);
        Medicament medicament = new Medicament("aspirin", pesho);
        Visitation visitation = new Visitation(new Date(), "pesho is late", pesho);

        this.patientService.persist(pesho);
        this.diagnoseService.persist(diagnose);
        this.medicamentService.persist(medicament);
        this.visitationService.persist(visitation);
    }
}