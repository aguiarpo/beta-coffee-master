package com.beta.coffee.betacoffee.service;

import com.beta.coffee.betacoffee.models.User;
import com.beta.coffee.betacoffee.models.enums.LevelsOfAccess;
import com.beta.coffee.betacoffee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("dev")
public class UserInit {
    private final UserRepository userRepository;

    @Autowired
    public UserInit(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void createTest() {
        if (userRepository.findByEmail("eduardo.aguiarpo@gmail.com") == null) {
            User admin = new User();
            admin.setEmail("eduardo.aguiarpo@gmail.com");
            admin.setPassword("12345678");
            admin.setName("Eduardo Aguiar");
            admin.setType(LevelsOfAccess.ADMIN);
            userRepository.save(admin);
        }
    }

}