package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.B2User;
import com.courses.assignment.citizen.model.register.B2Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface B2Repo {
    List<B2User> getAll();
    B2User getById(String id);
    void createUser(B2Register register);
    void updateUser(B2User b2User);
    void deleteUser(String id);
}
