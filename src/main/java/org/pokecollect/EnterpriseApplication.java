package org.pokecollect;

import org.pokecollect.dao.UserRepository;
import org.pokecollect.dto.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class EnterpriseApplication {

    public static void main(String[] args) {

        SpringApplication.run(EnterpriseApplication.class, args);

        }
/**
    @Bean
    CommandLineRunner commandLineRunner(UserRepository user, PasswordEncoder encoder) {
        return args -> {
            user.save(new User("admin", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
            user.save(new User("user", encoder.encode("password"), "ROLE_USER"));
            user.save(new User("staff", encoder.encode("password"), "ROLE_USER,ROLE_STAFF"));
        };
    }
**/
}