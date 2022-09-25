package com.example.carproject.services.inter;

public interface AccountService {
    Double getUserAccountBalance(Integer userId, String userName);

    Double increaseBalance(Double balance, Integer userId);

    Double doVIP(Integer id);
}
