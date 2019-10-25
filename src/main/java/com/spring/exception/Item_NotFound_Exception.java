package com.spring.exception;

public class Item_NotFound_Exception extends RuntimeException {
    public Item_NotFound_Exception(String exception){
        super(exception);
    }
}
