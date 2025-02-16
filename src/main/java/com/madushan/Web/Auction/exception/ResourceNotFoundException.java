package com.madushan.Web.Auction.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
