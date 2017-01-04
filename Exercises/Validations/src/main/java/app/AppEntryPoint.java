package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppEntryPoint {

    public static void main(String[] args) {
        //ANSRBuilder.build(BuilderStrategy.REPOSITORY_AND_SERVICES);
        SpringApplication.run(AppEntryPoint.class, args);
    }
}
