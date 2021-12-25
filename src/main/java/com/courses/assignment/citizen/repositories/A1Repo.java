package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.A1User;
import com.courses.assignment.citizen.model.register.A1Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface A1Repo {
    List<A1User> getAll();
    A1User getById(String id);
    void createUser(A1Register register);
    void updateUser(A1User a1User);
    void deleteUser(String id);
}
