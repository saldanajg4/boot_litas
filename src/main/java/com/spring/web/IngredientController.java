package com.spring.web;

import com.spring.entity.Ingredient;
import com.spring.entity.Item;
import com.spring.service.Ingredient_Service;
import com.spring.service.Item_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/litas")
public class IngredientController {

    private Ingredient_Service ingredient_Service;
    private Item_Service item_service;

    @Autowired
    public void setItem_service(Item_Service item_service){
        this.item_service = item_service;
    }

    @Autowired
    public void setIngredient_service(Ingredient_Service ingredient_Service){
        this.ingredient_Service = ingredient_Service;
    }

    @RequestMapping(value = "/ingredient", method = RequestMethod.POST)
    public ResponseEntity<Ingredient> saveIngredient(Ingredient ingredient){
        Ingredient ing = this.ingredient_Service.saveIngredient(ingredient);
        return new ResponseEntity<Ingredient>(ing, HttpStatus.OK);
    }

    //this method for OneToMany relationship
//    @RequestMapping(value = "/item/{itemid}/ingredients", method = RequestMethod.POST)
//    private ResponseEntity<Ingredient> createIngredient(@PathVariable (value="itemid") Long itemid,
//                                            @Valid @RequestBody Ingredient ingredient){
//        Item item = this.item_service.getItem(itemid);
//        ingredient.setItem(item);
//        Ingredient ing = this.ingredient_Service.saveIngredient(ingredient);
//        return new ResponseEntity<Ingredient>(ing,HttpStatus.OK);
//    }


    @GetMapping("/ingredients")
    public ResponseEntity<Iterable<Ingredient>> getAllIngredients(){
        Iterable<Ingredient> list= this.ingredient_Service.getAllIngredients();
        return new ResponseEntity<Iterable<Ingredient>>(list,HttpStatus.OK);
    }

    @GetMapping("/ingredient/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id")Long id){
        Ingredient ing = this.ingredient_Service.getIngredientById(id);
        return new ResponseEntity<Ingredient>(ing,HttpStatus.OK);
    }

}
