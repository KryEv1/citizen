package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.dto.B1UserDto;
import com.courses.assignment.citizen.model.entities.B1User;
import com.courses.assignment.citizen.model.register.B1Register;
import com.courses.assignment.citizen.repositories.B1Repo;
import com.courses.assignment.citizen.services.B1Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class B1ServiceImpl implements B1Service {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private B1Repo b1Repo;

    @Override
    public List<B1UserDto> getAll() {
        return b1Repo.getAll().stream().map(b1User -> modelMapper.map(b1User, B1UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public B1UserDto getById(String id) {
        return modelMapper.map(b1Repo.getById(id),B1UserDto.class);
    }

    @Override
    public void createUser(B1Register register) {
        b1Repo.createUser(register);
    }

    @Override
    public void updateUser(B1User b1User) {
        b1Repo.updateUser(b1User);
    }

    @Override
    public void deleteUser(String id) {
        b1Repo.deleteUser(id);
    }
}
