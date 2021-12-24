package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.entities.A3User;
import com.courses.assignment.citizen.model.register.A3Register;
import com.courses.assignment.citizen.repositories.A3Repo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class A3RepoImpl implements A3Repo {
    @Override
    public List<A3User> getAll() {
        return null;
    }

    @Override
    public A3User getById(int id) {
        return null;
    }

    @Override
    public void createUser(A3Register register) {

    }

    @Override
    public void updateUser(A3User a3User) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
