package com.spring.service;

import com.spring.entity.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Ingredient_Repository extends JpaRepository<Ingredient, Long> {
//    Page<Ingredient> findByItemId(Long item_id, Pageable pageable);
//    Optional<Ingredient> findByIdAndItemId(Long ingredient_id, Long item_id);
}
