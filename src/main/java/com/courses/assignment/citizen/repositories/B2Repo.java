package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.B2User;
import com.courses.assignment.citizen.model.register.B2Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface B2Repo {
    public List<B2User> getAll();
    public B2User getById(int id);
    public void createUser(B2Register register);
    public void updateUser(B2User b2User);
    public void deleteUser(int id);
}
