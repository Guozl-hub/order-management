package com.example.ordermanagement.exception;

public class CanNotFoundOrderException extends RuntimeException{
    public CanNotFoundOrderException(String message){super(message);}

    public CanNotFoundOrderException(String message, Throwable cause) {
        super(message, cause);
    }

}
