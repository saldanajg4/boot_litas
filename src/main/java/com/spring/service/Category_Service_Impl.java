package com.spring.service;

import com.spring.entity.Category;
import com.spring.exception.Category_NotFound_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Category_Service_Impl implements Category_Service {
    @Autowired
    private Category_Repository category_repository;

    @Override
    public Iterable<Category> listCategories() {
        return this.category_repository.findAll();
    }

    @Override
    public Category getCategory(long id) {
        Optional<Category> cat =this.category_repository.findById(id);
        if(cat.isPresent())
            return cat.get();
        else
            throw new Category_NotFound_Exception("Category Not Found");
    }
}
