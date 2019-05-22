package com.revan.SpringStarter.dao;

import com.revan.SpringStarter.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            if(repository.findAll().size() == 0) {
                log.info("Preloading: " + repository.save(new User("Srinivas Pothukuchi", "Software Developer")));
                log.info("Preloading: " + repository.save(new User("Pavani Pothukuchi", "Sales Analyst")));
                log.info("Preloading: " + repository.save(new User("Revanth Pothukuchi", "Software Developer")));
                log.info("Preloading: " + repository.save(new User("Varenya Pothukuchi", "Artist?")));
            }
        };
    }
}
