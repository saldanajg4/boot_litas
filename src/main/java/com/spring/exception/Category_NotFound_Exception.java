package com.spring.exception;

public class Category_NotFound_Exception extends RuntimeException {
    public Category_NotFound_Exception(String exception){
        super(exception);
    }
}
