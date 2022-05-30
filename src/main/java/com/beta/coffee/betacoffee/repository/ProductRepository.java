package com.beta.coffee.betacoffee.repository;

import com.beta.coffee.betacoffee.models.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Query(value = "SELECT * FROM product where id = :id",
    nativeQuery = true)
    Product findByCode(Long id);
    @Query(value = "SELECT * FROM product where name like :name%",
    nativeQuery = true)
    Page<Product> findByNameLike(String name, Pageable pageable);
} 