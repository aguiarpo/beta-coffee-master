package com.beta.coffee.betacoffee.repository;

import com.beta.coffee.betacoffee.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Category findById(Short id);
    Category findByName(String name);
} 