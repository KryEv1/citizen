package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Account;
import com.courses.assignment.citizen.model.register.UserRegister;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo {
    public List<Account> getAll();
    public Account getById(int id);
    public Account getByEmail(String email);
    public void createAccount(UserRegister register);
    public void deleteAccount(int id);
    public void updatePassword(String password, int id);
    public void updateEmail(String email, int id);
    public boolean checkEmail(String email);
    public boolean checkUsername(String username);
}
