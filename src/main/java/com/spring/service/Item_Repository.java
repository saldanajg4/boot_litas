package com.spring.service;

import com.spring.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface Item_Repository extends CrudRepository<Item, Long> {
}
