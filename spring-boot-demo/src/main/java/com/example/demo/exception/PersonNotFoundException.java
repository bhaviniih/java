package com.example.demo.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(int id) {
        super("Person not found with id " + id);
    }
}

