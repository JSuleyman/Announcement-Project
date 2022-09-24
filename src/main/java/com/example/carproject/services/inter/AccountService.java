package com.example.carproject.services.inter;

import com.example.carproject.exceptions.AccountBalanceException;
import com.example.carproject.models.Account;

public interface AccountService {
    Double getUserAccountBalance(Integer userId, String password);

    Double increaseBalance(Double balance, Integer userId, String password);

    Double doVIP(Integer id, String password);
}
