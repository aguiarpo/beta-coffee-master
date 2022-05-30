package com.beta.coffee.betacoffee.repository;

import com.beta.coffee.betacoffee.models.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Category findById(Short id);
    @Query(value = "SELECT * FROM category where name like :name%",
    nativeQuery = true)
    Page<Category> findByNameLike(String name, Pageable pageable);
} 