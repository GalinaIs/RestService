package com.mycompany.entity.exception;

public class ManagerNotFountException extends RuntimeException {
    public ManagerNotFountException(Long id) {
        super("Could not find manager with id " + id);
    }
}
