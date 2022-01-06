package com.example.ordermanagement.exception;

public class CanNotFoundOrderException extends RuntimeException{
    private static final long serialVersionUID = 5401989835535712466L;

    public CanNotFoundOrderException(String message){super(message);}

    public CanNotFoundOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
