package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.User;
import com.courses.assignment.citizen.model.register.UserRegister;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {
    void createUser(UserRegister register);
    void update(User user);
    User getByAccount(int accountID);
}
