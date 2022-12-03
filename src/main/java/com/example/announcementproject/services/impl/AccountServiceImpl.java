package com.example.announcementproject.services.impl;

import com.example.announcementproject.exceptions.AccountBalanceException;
import com.example.announcementproject.exceptions.UserNotFoundException;
import com.example.announcementproject.models.Account;
import com.example.announcementproject.models.User;
import com.example.announcementproject.repositories.AccountRepository;
import com.example.announcementproject.repositories.UserRepository;
import com.example.announcementproject.services.inter.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    private final UserRepository userRepository;

    @Override
    public Double getByUserId(Integer userId) {
        User user = userRepository.getUserById(userId).stream()
                .findFirst()
                .orElseThrow(UserNotFoundException::new);

        Account account = accountRepository.getUserAccount(user);

        if (Objects.isNull(account)) {
            Account newAccount = Account.builder()
                    .balance(0.0)
                    .userId(user)
                    .vip(false)
                    .build();
            accountRepository.save(newAccount);
            return newAccount.getBalance();
        }

        return account.getBalance();
    }

    @Override
    public Double increaseBalance(Double amount, Integer userId) {
        User user = userRepository.getUserById(userId).stream()
                .findFirst()
                .orElseThrow(UserNotFoundException::new);

        Double getBalance = getByUserId(userId);

        Account account = accountRepository.getUserAccount(user);
        Double newBalance = getBalance + amount;
        account.setBalance(newBalance);
        accountRepository.save(account);

        return account.getBalance();
    }

    public Double doVIP(Integer userId) {
        User user = userRepository.getUserById(userId).stream()
                .findFirst()
                .orElseThrow(UserNotFoundException::new);

        Double getBalance = getByUserId(userId);
        Account account = accountRepository.getUserAccount(user);

        if (getBalance >= 15) {
            Double newBalance = getBalance - 15;
            account.setBalance(newBalance);
            account.setVip(true);
            accountRepository.save(account);
        } else {
            throw new AccountBalanceException();
        }

        return account.getBalance();
    }
}
