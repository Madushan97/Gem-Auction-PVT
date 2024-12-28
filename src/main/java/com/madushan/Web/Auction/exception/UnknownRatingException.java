package com.madushan.Web.Auction.exception;

public class UnknownRatingException extends RuntimeException {

    public UnknownRatingException(String msg) {
        super(msg);
    }

    public UnknownRatingException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
