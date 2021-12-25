package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.dto.A3UserDto;
import com.courses.assignment.citizen.model.entities.A3User;
import com.courses.assignment.citizen.model.register.A3Register;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface A3Service {
    List<A3UserDto> getAll();
    A3UserDto getById(int id);
    void createUser(A3Register register);
    void updateUser(A3User a3User);
    void deleteUser(int id);
}
