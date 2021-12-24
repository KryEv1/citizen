package com.courses.assignment.citizen.model.repositories;

import com.courses.assignment.citizen.model.entities.A1User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface A2Repo {
    public List<A1User> getAll();
    public A1User getById(int id);
    public void createUser(A1User a1User);
    public void updateUser(A1User a1User);
    public void deleteUser(int id);
}
