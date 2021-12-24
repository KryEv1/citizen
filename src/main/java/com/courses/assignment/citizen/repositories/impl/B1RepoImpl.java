package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.entities.B1User;
import com.courses.assignment.citizen.model.register.B1Register;
import com.courses.assignment.citizen.repositories.B1Repo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class B1RepoImpl implements B1Repo {
    @Override
    public List<B1User> getAll() {
        return null;
    }

    @Override
    public B1User getById(int id) {
        return null;
    }

    @Override
    public void createUser(B1Register register) {

    }

    @Override
    public void updateUser(B1User b1User) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
