package com.beta.coffee.betacoffee.endpoints;

import com.beta.coffee.betacoffee.models.Request;
import com.beta.coffee.betacoffee.repository.RequestRepository;

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
@RequestMapping("v1")
public class RequestEndpoints {

    private final RequestRepository requestDao;

    @Autowired
    public RequestEndpoints(RequestRepository requestDao) {
        this.requestDao = requestDao;
    }

    
    @GetMapping(path = "barista/request")
    public ResponseEntity<?> findAll(Pageable pageable){
        return new ResponseEntity<>(requestDao.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "barista/request/name/{name}")
    public ResponseEntity<?> findByNameLike(@PathVariable String name, Pageable pageable){
        return new ResponseEntity<>(requestDao.findByNameLike(name, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "admin/request/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(requestDao.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "user/request")
    public ResponseEntity<?> create(@RequestBody Request request){
        return new ResponseEntity<>(requestDao.save(request), HttpStatus.OK);
    }

    @PutMapping(path = "barista/request")
    public ResponseEntity<?> edit(@RequestBody Request request){
        if(request.getId() > 0){
            return new ResponseEntity<>(requestDao.save(request), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
