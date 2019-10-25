package com.spring.exception;

public class Section_NotFound_Exception extends RuntimeException {
    public Section_NotFound_Exception(String exception){
        super(exception);
    }
}
