package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Account;
import com.courses.assignment.citizen.model.register.UserRegister;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo {
    List<Account> getAll();
    Account getById(int id);
    Account getByEmail(String email);
    void createAccount(UserRegister register);
    void deleteAccount(int id);
    void updatePassword(String password, int id);
    void updateEmail(String email, int id);
    boolean checkEmail(String email);
    boolean checkUsername(String username);
}
