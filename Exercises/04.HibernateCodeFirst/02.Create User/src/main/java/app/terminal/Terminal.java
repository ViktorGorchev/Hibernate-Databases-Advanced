package app.terminal;

import app.domain.User;
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

    @Override
    public void run(String... strings) throws Exception {

        File picture = new File("res/smallpic.jpg");
        byte[] pictureBytes = new byte[(int) picture.length()];
        FileInputStream fis = new FileInputStream(picture);
        fis.read(pictureBytes);
        fis.close();

        User pesho = new User("pesho", "Aa#242dsa34", "softuny@uni.bg", pictureBytes, new Date(), new Date(), 30, false);
        this.userService.persist(pesho);

        User gosho = new User("gosho", "Aa#242dsa34", "softuny@uni.bg", pictureBytes, new Date(), new Date(), 15, false);
        this.userService.persist(gosho);
    }
}
