package com.spring.service;

import com.spring.entity.Item;

public interface Item_Service {
    Iterable<Item> listItems();
    Item getItem(long id);
}
