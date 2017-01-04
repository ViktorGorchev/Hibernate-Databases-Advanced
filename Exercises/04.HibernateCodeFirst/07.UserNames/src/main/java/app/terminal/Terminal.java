package app.terminal;

import app.domain.Town;
import app.domain.User;
import app.service.TownService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private TownService townService;

    @Override
    public void run(String... strings) throws Exception {

        Town burgas = new Town("Burgas", "Bulgaria");
        Town shumen = new Town("Shumen", "Bulgaria");

        File picture = new File("res/smallpic.jpg");
        byte[] pictureBytes = new byte[(int) picture.length()];
        FileInputStream fis = new FileInputStream(picture);
        fis.read(pictureBytes);
        fis.close();

        User rado = new User(
                "Rado",
                "Radov",
                "pesho",
                "Aa#242dsa34",
                "softuny@uni.bg",
                pictureBytes,
                new Date(),
                new Date(),
                30,
                false,
                burgas,
                shumen);

        User spas = new User(
                "Spas",
                "Ivanov",
                "gosho",
                "Aa#242dsa34",
                "softuny@uni.bg",
                pictureBytes,
                new Date(),
                new Date(),
                15,
                false,
                shumen,
                shumen);

        this.townService.persist(burgas);
        this.townService.persist(shumen);
        this.userService.persist(rado);
        this.userService.persist(spas);
    }
}