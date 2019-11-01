package com.spring.web;

import com.spring.entity.Category;
import com.spring.entity.Item;
import com.spring.entity.Section;
import com.spring.exception.Item_NotFound_Exception;
import com.spring.service.Category_Repository;
import com.spring.service.Item_Repository;
import com.spring.service.Item_Service;
import com.spring.service.Section_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/litas")
public class ItemController {
    private Item_Service item_service;
    private Item_Repository item_repository;
    private Section_Repository section_repository;

    @Autowired
    public void setSection_repository(Section_Repository section_repository) {
        this.section_repository = section_repository;
    }

    @Autowired
    public void setItem_repository(Item_Repository item_repository) {
        this.item_repository = item_repository;
    }

    //check how Item_service is called using Autowired
    @Autowired
    public void setItem_service(Item_Service item_service){
        this.item_service = item_service;
    }

    @GetMapping("/items")
//    public List<Item> getAllItems(){
    public ResponseEntity<Iterable<Item>> getAllItems(){
        Iterable<Item> list = this.item_service.listItems();
        return new ResponseEntity<Iterable<Item>>(list, HttpStatus.OK);
//        return this.item_repository.findAll();
    }

    @GetMapping("/sections")
    public ResponseEntity<Iterable<Section>> getSections() {
        Iterable<Section> list = this.section_repository.findAll();
        return new ResponseEntity<Iterable<Section>>(list,HttpStatus.OK);
    }
    @GetMapping("/sections/{id}")
    public ResponseEntity<Section> getSection(@PathVariable ("id") Long id) {
        Optional<Section> sec = this.section_repository.findById(id);
        if(sec.isPresent())
            return new ResponseEntity<Section>(sec.get(),HttpStatus.OK);
        else
            return null;
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id")long id){
        try{
            Item item = this.item_service.getItem(id);
            return new ResponseEntity<Item>(item,HttpStatus.OK);
        }
        catch (Item_NotFound_Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Item Not Found");
        }
    }

    @RequestMapping(value = "/categories/{cid}/item", method = RequestMethod.POST)
//    @RequestMapping(value = "/items", method = RequestMethod.POST)
    private ResponseEntity<Item> createItem(HttpServletRequest request,@PathVariable(value="cid") Long cid,
                                          @RequestBody Item item){
//        item.setCategory_id(cid);
        Item i = this.item_service.createItem(item);
        return new ResponseEntity<Item>(i,HttpStatus.OK);
    }

    @PutMapping("/updateItem")
//    public Ingredient updateIngredient(@RequestBody Ingredient newIngredient, @PathVariable ("id") Long id){
    public Item updateItem(@RequestBody Item newItem){
        return this.item_repository.findById(newItem.getItem_id())
                .map(item -> {
                    item.setItem_name(newItem.getItem_name());
                    item.setDescription(newItem.getDescription());
                    item.setPrice(newItem.getPrice());
                    item.setSectionObject(newItem.getSectionObject());
                    item.setCategoryObject(newItem.getCategoryObject());
                    return this.item_repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setItem_id(newItem.getItem_id());
                    return this.item_repository.save(newItem);
                });
    }


}
