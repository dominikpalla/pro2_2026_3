package cz.uhk.spring3;

import cz.uhk.spring3.model.User;
import cz.uhk.spring3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring3Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring3Application.class, args);
    }

    /*private UserService userService;

    @Autowired
    public Spring3Application(UserService userService) {
        this.userService = userService;
    }

    @Bean
    CommandLineRunner init(UserService userService) {
        return args -> {
            User user = new  User();
            user.setUsername("admin");
            user.setPassword("heslo");
            user.setName("Domča");
            user.setRole("ADMIN");
            user.setEmail("nereknu@cojetidotoho.com");
            userService.saveUser(user);
        };
    }*/

}
