package com.example.carproject.services.impl;

import com.example.carproject.exceptions.AccountBalanceException;
import com.example.carproject.exceptions.InCorrectPassword;
import com.example.carproject.exceptions.NotFoundUser;
import com.example.carproject.models.Account;
import com.example.carproject.models.User;
import com.example.carproject.repositories.AccountRepository;
import com.example.carproject.repositories.UserRepository;
import com.example.carproject.services.inter.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    AccountRepository accountRepository;
    UserRepository userRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Double getUserAccountBalance(Integer userId, String password) {

        User user = userRepository.getUserById(userId);
        Account account = accountRepository.getUserAccount(user);
        if (user == null) throw new NotFoundUser();
        {
            if (account != null) {
                if (!password.equals(user.getPassword())) throw new InCorrectPassword();
                {
                    return account.getBalance();
                }
            }
        }

        if (user != null && account == null) {
            if (!password.equals(user.getPassword())) throw new InCorrectPassword();
            {
                Account newAccount = Account.builder().balance(0.0).userId(user).vip(false).build();
                accountRepository.save(newAccount);
                return newAccount.getBalance();
            }
        }
        return null;
    }

    @Override
    public Double increaseBalance(Double balance, Integer userId, String password) {
        Double getBalance = getUserAccountBalance(userId, password);
        User user = userRepository.getUserById(userId);

        if (!password.equals(user.getPassword())) throw new InCorrectPassword();
        {
            Account account = accountRepository.getUserAccount(user);
            Double newBalance = getBalance + balance;
            account.setBalance(newBalance);
            accountRepository.save(account);
            return account.getBalance();
        }
    }

    public Double doVIP(Integer id, String password) {

        Double getBalance = getUserAccountBalance(id, password);
        User user = userRepository.getUserById(id);
        Account account = accountRepository.getUserAccount(user);

        if (!(password.equals(user.getPassword()) && getBalance >= 15)) throw new AccountBalanceException();
        {
            Double newBalance = getBalance - 15;
            account.setBalance(newBalance);
            account.setVip(true);
            accountRepository.save(account);
            return account.getBalance();
        }
    }
}
