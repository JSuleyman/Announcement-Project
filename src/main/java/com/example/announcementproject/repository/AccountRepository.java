package com.example.announcementproject.repository;

import com.example.announcementproject.model.Account;
import com.example.announcementproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
      @Query("SELECT a from Account a where a.userId = ?1")
      Account getUserAccount(User userId); //TODO User olmayanda isdemir
}
