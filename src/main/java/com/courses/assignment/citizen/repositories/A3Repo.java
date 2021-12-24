package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.A3User;
import com.courses.assignment.citizen.model.register.A3Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface A3Repo {
    List<A3User> getAll();
    A3User getById(int id);
    void createUser(A3Register register);
    void updateUser(A3User a3User);
    void deleteUser(int id);
}
