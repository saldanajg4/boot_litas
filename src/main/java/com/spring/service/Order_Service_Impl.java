package com.spring.service;


import com.spring.entity.Customer_Order;
import com.spring.exception.Customer_Order_NotFound_Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Optional;

@Service
public class Order_Service_Impl implements Order_Service {
    @Autowired
    private Order_Repository order_repository;

    /*****
     * this findAll() comes from the spring.data.repository.CrudRepository
     * CrudRepository<Customer_Order, Long>
     * @return
     */
    @Override
    public Iterable<Customer_Order> listOrders() {
        return order_repository.findAll();
    }

    @Override
    public Customer_Order getOrder(long id) {
        try {
            Optional<Customer_Order> optionalCustomer_order = order_repository.findById(id);

            if (optionalCustomer_order.isPresent())
                return optionalCustomer_order.get();
            else
                throw new Customer_Order_NotFound_Exception("Customer_Order Not Found");
        }
        catch(Exception ex){
            throw new Customer_Order_NotFound_Exception("Customer_Order Not Found" + ex);
        }
    }


}
