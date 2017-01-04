package app.terminal;

import app.domain.*;
import app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @Autowired
    private DoctorService doctorService;

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
        Doctor doctor = new Doctor("Ivan", "human brain");
        Visitation visitation = new Visitation(new Date(), "pesho is late", pesho, doctor);

        this.patientService.persist(pesho);
        this.diagnoseService.persist(diagnose);
        this.medicamentService.persist(medicament);
        this.doctorService.persist(doctor);
        this.visitationService.persist(visitation);

        Set<Visitation> visitations = new HashSet<>();
        visitations.add(visitation);
        doctor.setVisitations(visitations);
    }
}