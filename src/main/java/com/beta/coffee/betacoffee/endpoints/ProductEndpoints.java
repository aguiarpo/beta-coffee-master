package com.beta.coffee.betacoffee.endpoints;

import com.beta.coffee.betacoffee.models.Product;
import com.beta.coffee.betacoffee.repository.ProductRepository;
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
public class ProductEndpoints {

    private final ProductRepository productDao;

    @Autowired
    public ProductEndpoints(ProductRepository productDao) {
        this.productDao = productDao;
    }

    
    @GetMapping(path = "product")
    public ResponseEntity<?> findAll(Pageable pageable){
        return new ResponseEntity<>(productDao.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "product/name/{name}")
    public ResponseEntity<?> findByNameLike(@PathVariable String name, Pageable pageable){
        return new ResponseEntity<>(productDao.findByNameLike(name, pageable), HttpStatus.OK);
    }

    @GetMapping(path = "product/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(productDao.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "product")
    public ResponseEntity<?> create(@RequestBody Product product){
        return new ResponseEntity<>(productDao.save(product), HttpStatus.OK);
    }

    @PutMapping(path = "product")
    public ResponseEntity<?> edit(@RequestBody Product product){
        if(product.getId() > 0){
            return new ResponseEntity<>(productDao.save(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
