package com.mycompany.controller.advice;

import com.mycompany.entity.exception.ClientNotFountException;
import com.mycompany.entity.exception.ManagerNotFountException;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ClientNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorMessage clientNotFoundHandler(ClientNotFountException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(ManagerNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorMessage managerNotFoundHandler(ManagerNotFountException ex) {
        return new ErrorMessage(ex.getMessage());
    }

    @Value
    private static class ErrorMessage {
        private final String error;

        private ErrorMessage(String error) {
            this.error = error;
        }
    }
}
