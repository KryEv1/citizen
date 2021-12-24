package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.A1User;
import com.courses.assignment.citizen.model.register.A1Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface A1Repo {
    public List<A1User> getAll();
    public A1User getById(int id);
    public void createUser(A1Register register);
    public void updateUser(A1User a1User);
    public void deleteUser(int id);
}
