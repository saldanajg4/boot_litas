package com.spring.service;

import com.spring.entity.Ingredient;
import com.spring.exception.Item_NotFound_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class Ingredient_Service_Impl implements Ingredient_Service {

    @Autowired
    private Ingredient_Repository ingredient_repository;

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredient_repository.save(ingredient);
    }

    @Override
    public Iterable<Ingredient> getAllIngredients() {
        return this.ingredient_repository.findAll();
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        Optional<Ingredient> ing = this.ingredient_repository.findById(id);
        if(ing.isPresent())
            return ing.get();
        else
            throw new Item_NotFound_Exception("Not found");
    }
}
