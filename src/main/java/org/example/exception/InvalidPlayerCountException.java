package org.example.exception;

public class InvalidPlayerCountException extends Exception{
    public InvalidPlayerCountException(String message){
        super(message);
    }
}
