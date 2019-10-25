package com.spring.service;

import com.spring.entity.Customer_Order;
import org.springframework.data.repository.CrudRepository;

public interface Order_Repository extends CrudRepository<Customer_Order, Long> {
}
