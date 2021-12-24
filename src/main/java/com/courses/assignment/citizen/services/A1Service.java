package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.dto.A1UserDto;
import com.courses.assignment.citizen.model.entities.A1User;
import com.courses.assignment.citizen.model.register.A1Register;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface A1Service {
    public List<A1UserDto> getAll();
    public A1UserDto getById(int id);
    public void createUser(A1Register register);
    public void updateUser(A1User a1User);
    public void deleteUser(int id);
}
