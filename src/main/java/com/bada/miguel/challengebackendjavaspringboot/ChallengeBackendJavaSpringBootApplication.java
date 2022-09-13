package com.bada.miguel.challengebackendjavaspringboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChallengeBackendJavaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeBackendJavaSpringBootApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
