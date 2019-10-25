package com.spring.web;

import com.spring.entity.Item;
import com.spring.exception.Item_NotFound_Exception;
import com.spring.service.Item_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/litas")
public class ItemController {
    private Item_Service item_service;

    //check how Item_service is called using Autowired
    @Autowired
    public void setItem_service(Item_Service item_service){
        this.item_service = item_service;
    }

    @GetMapping("/items")
    public ResponseEntity<Iterable<Item>> getAllItems(){
        Iterable<Item> list = this.item_service.listItems();
        return new ResponseEntity<Iterable<Item>>(list, HttpStatus.OK);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id")long id){
        try{
            Item item = this.item_service.getItem(id);
            return new ResponseEntity<Item>(item,HttpStatus.OK);
        }
        catch (Item_NotFound_Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Item Not Found");
        }
    }
}
