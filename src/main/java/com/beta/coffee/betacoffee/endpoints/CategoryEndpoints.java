package com.beta.coffee.betacoffee.endpoints;

import com.beta.coffee.betacoffee.models.Category;
import com.beta.coffee.betacoffee.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/admin")
public class CategoryEndpoints {

    private final CategoryRepository categoryDao;

    @Autowired
    public CategoryEndpoints(CategoryRepository categoryDao) {
        this.categoryDao = categoryDao;
    }

    
    @GetMapping(path = "category")
    public ResponseEntity<?> findAll(Pageable pageable){
        return new ResponseEntity<>(categoryDao.findAll(pageable), HttpStatus.OK);
    }


    @PostMapping(path = "category")
    public ResponseEntity<?> create(@RequestBody Category category){
        return new ResponseEntity<>(categoryDao.save(category), HttpStatus.OK);
    }

    @PutMapping(path = "category")
    public ResponseEntity<?> edit(@RequestBody Category category){
        if(category.getId() > 0){
            return new ResponseEntity<>(categoryDao.save(category), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
