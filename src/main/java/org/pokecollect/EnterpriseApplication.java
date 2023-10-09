package org.pokecollect;

import org.pokecollect.service.PokeFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class EnterpriseApplication {

    public static void main(String[] args) {
        JFrame frame = new PokeFrame();
        SpringApplication.run(EnterpriseApplication.class, args);
    }

}