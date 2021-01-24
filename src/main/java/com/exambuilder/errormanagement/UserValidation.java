package com.exambuilder.errormanagement;

public class UserValidation extends RuntimeException {
    public UserValidation(String message){
        super(message);
    }
    public UserValidation(String message,Throwable e){
        super(message,e);
    }
}
