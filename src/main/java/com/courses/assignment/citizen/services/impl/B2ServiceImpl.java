package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.dto.B2UserDto;
import com.courses.assignment.citizen.model.entities.B2User;
import com.courses.assignment.citizen.model.register.B2Register;
import com.courses.assignment.citizen.repositories.B2Repo;
import com.courses.assignment.citizen.services.B2Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class B2ServiceImpl implements B2Service {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private B2Repo b2Repo;

    @Override
    public List<B2UserDto> getAll() {
        return b2Repo.getAll().stream().map(b2User -> modelMapper.map(b2User, B2UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public B2UserDto getById(String id) {
        return modelMapper.map(b2Repo.getById(id), B2UserDto.class);
    }

    @Override
    public void createUser(B2Register register) {
        b2Repo.createUser(register);
    }

    @Override
    public void updateUser(B2User b2User) {
        b2Repo.updateUser(b2User);
    }

    @Override
    public void deleteUser(String id) {
        b2Repo.deleteUser(id);
    }
}
