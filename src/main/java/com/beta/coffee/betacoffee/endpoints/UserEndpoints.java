package com.beta.coffee.betacoffee.endpoints;

import com.beta.coffee.betacoffee.models.User;
import com.beta.coffee.betacoffee.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/admin")
public class UserEndpoints {

    private final UserRepository userDao;

    @Autowired
    public UserEndpoints(UserRepository userDao) {
        this.userDao = userDao;
    }

    
    @GetMapping(path = "users")
    public ResponseEntity<?> findAll(Pageable pageable){
        return new ResponseEntity<>(userDao.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "users/name/{name}")
    public ResponseEntity<?> findByNameLike(@PathVariable String name, Pageable pageable){
        return new ResponseEntity<>(userDao.findByNameLike(name, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "users/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(userDao.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "users")
    public ResponseEntity<?> create(@RequestBody User user){
        return new ResponseEntity<>(userDao.save(user), HttpStatus.OK);
    }

    @PutMapping(path = "users")
    public ResponseEntity<?> edit(@RequestBody User user){
        if(user.getId() > 0){
            return new ResponseEntity<>(userDao.save(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
