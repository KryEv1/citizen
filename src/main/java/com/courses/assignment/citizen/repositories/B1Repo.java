package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.B1User;
import com.courses.assignment.citizen.model.register.B1Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface B1Repo {
    List<B1User> getAll();
    B1User getById(String id);
    void createUser(B1Register register);
    void updateUser(B1User b1User);
    void deleteUser(String id);
}
