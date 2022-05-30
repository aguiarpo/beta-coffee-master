package com.beta.coffee.betacoffee.models;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "category_seq", sequenceName = "category_seq",
        initialValue = 1, allocationSize = 1)
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    Short id;

    @Column(unique = true)
    String name;
    
    @JsonIgnore
    @OneToMany(mappedBy="category")
    List<Product> products;

}