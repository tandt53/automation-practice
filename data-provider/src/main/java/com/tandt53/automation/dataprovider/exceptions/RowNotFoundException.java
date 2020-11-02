package com.tandt53.automation.dataprovider.exceptions;

public class RowNotFoundException extends Exception {

    public RowNotFoundException(String message){
        super(message);
    }

    public RowNotFoundException(String message, Throwable t){
        super(message, t);
    }
}
