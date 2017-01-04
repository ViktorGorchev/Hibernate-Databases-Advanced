package app.terminal;

import app.domain.User;
import app.service.TownService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private TownService townService;

    @Override
    public void run(String... strings) throws Exception {

        //11.
        String domain = "gmail.com";
        List<User> users = this.userService.findUsersByEmailDomain(domain);
        if (users.size() > 0) {
            for (User user : users) {
                System.out.println(user.getUsername() + " " + user.getEmail());
            }
        }else {
            System.out.println("No users found with email domain " + domain);
        }


        //12.
        Integer pixels = 100;
        Integer countPictures = this.userService.countGreaterProfilePictures(pixels);
        if (countPictures > 0) {
            System.out.printf("%d users have profile pictures wider than %d pixels%n", countPictures, pixels);
        }else {
            System.out.printf("No users have profile picture wider than %d pixels%n", pixels);
        }


        //13
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 9, 01);
        Date date = calendar.getTime();

        List<User> usersForDelete = this.userService.usresNotLoggedInAfterDate(date);
        int usersDeleted = usersForDelete.size();
        for (User user : usersForDelete) {
            user.setDeleted(true);
            this.userService.persist(user);
            this.userService.removeUser(user);
        }

        System.out.printf("%d users have been deleted%n", usersDeleted);
    }
}