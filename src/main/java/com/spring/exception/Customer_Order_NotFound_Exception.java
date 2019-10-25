package com.spring.exception;

public class Customer_Order_NotFound_Exception extends RuntimeException {
    public Customer_Order_NotFound_Exception(String exception){
        super(exception);
    }
}
