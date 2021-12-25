package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.dto.B2UserDto;
import com.courses.assignment.citizen.model.entities.B2User;
import com.courses.assignment.citizen.model.register.B2Register;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface B2Service {
    List<B2UserDto> getAll();
    B2UserDto getById(String id);
    void createUser(B2Register register);
    void updateUser(B2User b2User);
    void deleteUser(String id);
}
