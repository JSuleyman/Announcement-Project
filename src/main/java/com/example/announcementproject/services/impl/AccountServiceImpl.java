package com.example.announcementproject.services.impl;

import com.example.announcementproject.exceptions.AccountBalanceException;
import com.example.announcementproject.exceptions.NotFoundUser;
import com.example.announcementproject.models.Account;
import com.example.announcementproject.models.User;
import com.example.announcementproject.repositories.AccountRepository;
import com.example.announcementproject.repositories.UserRepository;
import com.example.announcementproject.services.inter.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;
    UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Double getUserAccountBalance(Integer userId, String userName) {

        User user = userRepository.getUserById(userId);
        Account account = accountRepository.getUserAccount(user);
        if (user == null) throw new NotFoundUser();
        {
            if (account != null) {
                if (!user.getName().equals(userName)) throw new NotFoundUser();
                {
                    return account.getBalance();
                }
            }
        }

        if (user != null && account == null) {
            Account newAccount = Account.builder().balance(0.0).userId(user).vip(false).build();
            accountRepository.save(newAccount);
            return newAccount.getBalance();
        }
        return null;
    }

    @Override
    public Double increaseBalance(Double balance, Integer userId) {
        User user = userRepository.getUserById(userId);
        String name = user.getName();

        Double getBalance = getUserAccountBalance(userId, name);


        Account account = accountRepository.getUserAccount(user);
        Double newBalance = getBalance + balance;
        account.setBalance(newBalance);
        accountRepository.save(account);
        return account.getBalance();

    }

    public Double doVIP(Integer id) {
        User user = userRepository.getUserById(id);
        String name = user.getName();

        Double getBalance = getUserAccountBalance(id, name);
        Account account = accountRepository.getUserAccount(user);

        if (!(getBalance >= 15)) throw new AccountBalanceException();
        {
            Double newBalance = getBalance - 15;
            account.setBalance(newBalance);
            account.setVip(true);
            accountRepository.save(account);
            return account.getBalance();
        }
    }
}
