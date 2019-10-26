package com.spring.web;

import com.spring.entity.Customer_Order;
import com.spring.exception.Customer_Order_NotFound_Exception;
import com.spring.service.Item_Service;
import com.spring.service.Order_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//spring mvc annotations
@RestController
@RequestMapping("/litas")
public class OrderController {
    private Order_Service order_service;

    @Autowired
    public void setOrder_service(Order_Service order_service){
        this.order_service = order_service;
    }

    @GetMapping("/orders")
    public ResponseEntity<Iterable<Customer_Order>> getAllOrders(){
        Iterable<Customer_Order> list = this.order_service.listOrders();
        return new ResponseEntity<Iterable<Customer_Order>>(list, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Customer_Order> getCustomer_Order(@PathVariable("id") long id){
        try {
            Customer_Order customer_order = this.order_service.getOrder(id);
            return new ResponseEntity<Customer_Order>(customer_order, HttpStatus.OK);
        }
        catch(Customer_Order_NotFound_Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order Not Found");
        }
    }
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Customer_Order> saveOrder(@RequestBody Customer_Order order){
        Customer_Order cOrder = this.order_service.saveOrder(order);
        return new ResponseEntity<Customer_Order>(cOrder, HttpStatus.OK);
    }
}
