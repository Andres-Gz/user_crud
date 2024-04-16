package org.example.usercrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("")
public class UserCrudApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserCrudApplication.class, args);
        System.out.println("Hello World!");
    }

}
