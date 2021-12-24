package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.B1User;
import com.courses.assignment.citizen.model.register.B1Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface B1Repo {
    public List<B1User> getAll();
    public B1User getById(int id);
    public void createUser(B1Register register);
    public void updateUser(B1User b1User);
    public void deleteUser(int id);
}
