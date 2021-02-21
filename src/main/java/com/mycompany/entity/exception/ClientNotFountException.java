package com.mycompany.entity.exception;

public class ClientNotFountException extends RuntimeException {
    public ClientNotFountException(Long id) {
        super("Could not find client with id " + id);
    }
}
