package app.terminal;

import app.service.TagService;
import app.service.TownService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private TownService townService;

    @Autowired
    private TagService tagService;

    @Override
    public void run(String... strings) throws Exception {
        //8.
//        Tag tag1 = new Tag();
//        tag1.setTagText("#summer");
//
//        Tag tag2 = new Tag();
//        tag2.setTagText("myCat");
//
//        Tag tag3 = new Tag();
//        tag3.setTagText("#no make up");
//
//        Tag tag4 = new Tag();
//        tag4.setTagText("#aaaaaaaaaaaaaaaaaaXCutThisEnd");
//
//        Tag tag5 = new Tag();
//        tag5.setTagText("me and my bff doing selfie");
//
//        this.tagService.save(tag1);
//        this.tagService.save(tag2);
//        this.tagService.save(tag3);
//        this.tagService.save(tag4);
//        this.tagService.save(tag5);
//
//        System.out.println(tag1.getTagText() + " was added to database");
//        System.out.println(tag2.getTagText() + " was added to database");
//        System.out.println(tag3.getTagText() + " was added to database");
//        System.out.println(tag4.getTagText() + " was added to database");
//        System.out.println(tag5.getTagText() + " was added to database");



    }
}