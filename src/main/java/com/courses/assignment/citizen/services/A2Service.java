package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.dto.A2UserDto;
import com.courses.assignment.citizen.model.entities.A2User;
import com.courses.assignment.citizen.model.register.A2Register;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface A2Service {
    List<A2UserDto> getAll();
    A2UserDto getById(int id);
    void createUser(A2Register register);
    void updateUser(A2User a2User);
    void deleteUser(int id);
}
