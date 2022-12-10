package com.example.announcementproject.controller;


import com.example.announcementproject.service.inter.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/balance")
    public ResponseEntity<Double> getByUserId(@RequestParam Integer userId) {
        return new ResponseEntity<>(accountService.getByUserId(userId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/balance")
    public ResponseEntity<Double> increaseBalance(@RequestParam Integer userId, @RequestParam Double amount) {
        return new ResponseEntity<>(accountService.increaseBalance(amount, userId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/vip")
    public ResponseEntity<Double> doVIP(@RequestParam Integer userId) {
        return new ResponseEntity<>(accountService.doVIP(userId), HttpStatus.ACCEPTED);
    }
}
