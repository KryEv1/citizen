package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.entities.B2User;
import com.courses.assignment.citizen.model.register.B2Register;
import com.courses.assignment.citizen.repositories.B2Repo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class B2RepoImpl implements B2Repo {
    @Override
    public List<B2User> getAll() {
        return null;
    }

    @Override
    public B2User getById(int id) {
        return null;
    }

    @Override
    public void createUser(B2Register register) {

    }

    @Override
    public void updateUser(B2User b2User) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
