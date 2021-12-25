package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.dto.B1UserDto;
import com.courses.assignment.citizen.model.entities.B1User;
import com.courses.assignment.citizen.model.register.B1Register;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface B1Service {
    List<B1UserDto> getAll();
    B1UserDto getById(String id);
    void createUser(B1Register register);
    void updateUser(B1User b1User);
    void deleteUser(String id);
}
