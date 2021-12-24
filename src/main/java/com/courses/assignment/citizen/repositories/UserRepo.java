package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.User;
import com.courses.assignment.citizen.model.register.UserRegister;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {
    public void createUser(UserRegister register);
    public void update(User user);
    public User getByAccount(int accountID);
}
