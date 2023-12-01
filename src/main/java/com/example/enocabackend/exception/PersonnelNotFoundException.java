package com.example.enocabackend.exception;

public class PersonnelNotFoundException extends RuntimeException{
    public PersonnelNotFoundException(String message){
        super(message);
    }
}
