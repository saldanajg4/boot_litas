package com.spring.service;

import com.spring.entity.Ingredient;

public interface Ingredient_Service {
    public Ingredient saveIngredient(Ingredient ingredient);
    Iterable<Ingredient> getAllIngredients();
    Ingredient getIngredientById(Long id);
}
