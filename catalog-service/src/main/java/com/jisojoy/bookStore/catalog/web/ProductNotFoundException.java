package com.jisojoy.bookStore.catalog.web;

public class ProductNotFoundException extends RuntimeException{

    ProductNotFoundException(String message){
        super(message);
    }

    public static ProductNotFoundException errorBycode(String code){
        return new ProductNotFoundException("product with code "+code+" not found.");
    }
}
