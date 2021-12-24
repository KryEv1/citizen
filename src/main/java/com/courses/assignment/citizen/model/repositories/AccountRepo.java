package com.courses.assignment.citizen.model.repositories;

import com.courses.assignment.citizen.model.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo {
    public List<Account> getAll();
    public Account getById(int id);
    public Account getByEmail(String email);
    public void createAccount(Account account);
    public void deleteAccount(int id);
    public void updatePassword(String password);
    public void updateEmail(String email);
    public boolean checkEmail(String email);
    public boolean checkUsername(String username);
}
