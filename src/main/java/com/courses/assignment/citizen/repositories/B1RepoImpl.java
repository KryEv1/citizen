package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.A1User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class B1RepoImpl implements B1Repo {
    @Override
    public List<A1User> getAll() {
        return null;
    }

    @Override
    public A1User getById(int id) {
        return null;
    }

    @Override
    public void createUser(A1User a1User) {

    }

    @Override
    public void updateUser(A1User a1User) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
