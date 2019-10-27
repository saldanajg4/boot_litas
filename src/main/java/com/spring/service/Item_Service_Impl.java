package com.spring.service;

import com.spring.entity.Item;
import com.spring.exception.Item_NotFound_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Item_Service_Impl implements Item_Service {
    @Autowired
    private Item_Repository item_repository;

    @Override
    public Item createItem(Item item) {
        return item_repository.save(item);
    }

    @Override
    public Iterable<Item> listItems() {
        return this.item_repository.findAll();
    }


    @Override
    public Item getItem(long id) {
                    Optional<Item> optionalItem = this.item_repository.findById(id);
                    if (optionalItem.isPresent())
                        return optionalItem.get();
                    else {
                        Item i = new Item();
                        i.setDescription("Item " + id + " not found");
                        return i;
                    }

    }

}
