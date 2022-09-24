package com.example.carproject.controllers;

import com.example.carproject.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = AccountBalanceException.class)
    public ResponseEntity<Object> balanceException(AccountBalanceException exception){
        return new ResponseEntity<>("There is not enough money in the balance to make VIP", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = InCorrectPassword.class)
    public ResponseEntity<Object> passwordException(InCorrectPassword exception){
        return new ResponseEntity<>("The password is incorrect", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = NotFoundUser.class)
    public ResponseEntity<Object> userException(NotFoundUser exception){
        return new ResponseEntity<>("There was no user", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NotFoundAnnouncement.class)
    public ResponseEntity<Object> announcementException(NotFoundAnnouncement exception){
        return new ResponseEntity<>("There was no such announcement", HttpStatus.NOT_FOUND);
    }
}
