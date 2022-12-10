package com.example.announcementproject.service.inter;

public interface AccountService {
    Double getByUserId(Integer userId);

    Double increaseBalance(Double amount, Integer userId);

    Double doVIP(Integer userId);
}
