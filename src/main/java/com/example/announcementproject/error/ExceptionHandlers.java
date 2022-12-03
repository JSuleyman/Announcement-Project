package com.example.announcementproject.error;

import com.example.announcementproject.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = AccountBalanceException.class)
    public ResponseEntity<Object> balanceException() {
        return new ResponseEntity<>("There is not enough money in the balance to make VIP", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = InCorrectPassword.class)
    public ResponseEntity<Object> passwordException() {
        return new ResponseEntity<>("The password is incorrect", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> userException() {
        return new ResponseEntity<>("There was no user", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AnnouncementNotFoundException.class)
    public ResponseEntity<Object> announcementException() {
        return new ResponseEntity<>("There was no such announcement", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CityNotFoundException.class)
    public ResponseEntity<Object> cityException() {
        return new ResponseEntity<>("There was no city", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = CityAlreadyExist.class)
    public ResponseEntity<Object> cityAlreadyExist() {
        return new ResponseEntity<>("City already exist", HttpStatus.ALREADY_REPORTED);
    }
}
