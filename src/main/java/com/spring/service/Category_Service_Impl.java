package com.spring.service;

import com.spring.DTO_Bean.Category_DTO;
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
    public com.spring.entity.Category saveCategory(Category cat) {
        return this.category_repository.save(cat);
    }

    @Override
    public Iterable<com.spring.entity.Category> listCategories() {
        return this.category_repository.findAll();
    }

    @Override
    public com.spring.entity.Category getCategory(long id) {
        Optional<com.spring.entity.Category> cat =this.category_repository.findById(id);
        if(cat.isPresent())
            return cat.get();
        else
            throw new Category_NotFound_Exception("Category Not Found");
    }
}
