package com.example.carproject.controllers;


import com.example.carproject.services.inter.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class AccountController {
    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getUserBalance")
    public ResponseEntity<Double> getUserAccountBalance(@RequestParam Integer id, @RequestParam String userName){
        return new ResponseEntity<>(accountService.getUserAccountBalance(id, userName), HttpStatus.ACCEPTED);
    }

    @PostMapping("/increaseBalance")
    ResponseEntity<Double> increaseBalance(@RequestParam Double balance, @RequestParam Integer id){
        return new ResponseEntity<>(accountService.increaseBalance(balance, id), HttpStatus.ACCEPTED);
    }


    @PostMapping("/doVIP")
    ResponseEntity<Double> doVIP(@RequestParam Integer id){
        return new ResponseEntity<>(accountService.doVIP(id), HttpStatus.ACCEPTED);
    }
}
