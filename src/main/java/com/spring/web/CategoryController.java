package com.spring.web;

import com.spring.DTO_Bean.Category_DTO;
import com.spring.DTO_Bean.Ingredient;
import com.spring.entity.Category;
import com.spring.service.Category_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/litas")
public class CategoryController {

    private Category_Service category_service;

    @Autowired
    public void setCategory_service(Category_Service category_service) {
        this.category_service = category_service;
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<Category> saveCategory(@RequestBody Category cat){
        Category c = this.category_service.saveCategory(cat);
        return new ResponseEntity<Category>(c, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> getAllCategories(){
        Iterable<Category> list = this.category_service.listCategories();
        return new ResponseEntity<Iterable<Category>>(list,HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
        Category cat = this.category_service.getCategory(id);
        return new ResponseEntity<Category>(cat, HttpStatus.OK);
    }

}
