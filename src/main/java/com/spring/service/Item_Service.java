package com.spring.service;

import com.spring.entity.Item;
import org.springframework.data.domain.Pageable;

public interface Item_Service {
    Item createItem(Item item);
    Iterable<Item> listItems();
    Item getItem(long id);
}
