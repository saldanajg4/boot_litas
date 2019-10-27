package com.spring.web;

import com.spring.entity.Item;
import com.spring.exception.Item_NotFound_Exception;
import com.spring.service.Item_Service;
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

    @RequestMapping(value = "/category/{cid}/item", method = RequestMethod.POST)
//    @RequestMapping(value = "/items", method = RequestMethod.POST)
    private ResponseEntity<Item> createItem(HttpServletRequest request,@PathVariable(value="cid") Long cid,
                                          @RequestBody Item item){
        item.setCategory_id(cid);
        Item i = this.item_service.createItem(item);
        return new ResponseEntity<Item>(i,HttpStatus.OK);
    }


}
