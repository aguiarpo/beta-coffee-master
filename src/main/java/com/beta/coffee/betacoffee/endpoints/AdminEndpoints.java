package com.beta.coffee.betacoffee.endpoints;

import java.util.List;

import com.beta.coffee.betacoffee.models.User;
import com.beta.coffee.betacoffee.models.enums.LevelsOfAccess;
import com.beta.coffee.betacoffee.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class AdminEndpoints{

    private final UserRepository userDao;

    @Autowired
    public AdminEndpoints(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "create/admin")
    public ResponseEntity<?> createAdmin(){
        List<User> adminUsers = userDao.findByType(LevelsOfAccess.ADMIN);
        if(adminUsers.isEmpty()){
            User primaryAdmin = new User("Lucas",
             "1@gmail.com", "123", LevelsOfAccess.ADMIN);
             User savedAdmin = userDao.save(primaryAdmin);
             return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
} 