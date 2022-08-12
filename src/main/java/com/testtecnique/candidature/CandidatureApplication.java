package com.testtecnique.candidature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins="*")
public class CandidatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandidatureApplication.class, args);
    }

}
