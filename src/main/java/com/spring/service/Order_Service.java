package com.spring.service;

import com.spring.entity.Customer_Order;

public interface Order_Service {
    Iterable<Customer_Order> listOrders();
    Customer_Order getOrder(long id);
}
