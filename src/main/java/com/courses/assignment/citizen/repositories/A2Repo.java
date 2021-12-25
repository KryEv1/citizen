package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.A2User;
import com.courses.assignment.citizen.model.register.A2Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface A2Repo {
    List<A2User> getAll();
    A2User getById(String id);
    void createUser(A2Register register);
    void updateUser(A2User a2User);
    void deleteUser(String id);
}
