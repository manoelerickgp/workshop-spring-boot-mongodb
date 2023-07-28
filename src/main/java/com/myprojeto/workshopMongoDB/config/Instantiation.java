package com.myprojeto.workshopMongoDB.config;

import com.myprojeto.workshopMongoDB.domain.User;
import com.myprojeto.workshopMongoDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria  = new User(null, "Maria Brown", "maria@gmail.com");
        User alex  = new User(null, "Alex Grey", "alex@gmail.com");
        User bob  = new User(null, "Bob Green", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
