package com.example.carproject.repositories;

import com.example.carproject.models.Account;
import com.example.carproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
      @Query("SELECT a from Account a where a.userId = ?1")
      Account getUserAccount(User userId);
}
