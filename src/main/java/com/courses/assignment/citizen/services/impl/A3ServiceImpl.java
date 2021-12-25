package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.dto.A3UserDto;
import com.courses.assignment.citizen.model.entities.A3User;
import com.courses.assignment.citizen.model.register.A3Register;
import com.courses.assignment.citizen.repositories.A3Repo;
import com.courses.assignment.citizen.services.A3Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class A3ServiceImpl implements A3Service {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private A3Repo a3Repo;

    @Override
    public List<A3UserDto> getAll() {
        return a3Repo.getAll().stream().map(a3User -> modelMapper.map(a3User, A3UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public A3UserDto getById(String id) {
        return modelMapper.map(a3Repo.getById(id), A3UserDto.class);
    }

    @Override
    public void createUser(A3Register register) {
        a3Repo.createUser(register);
    }

    @Override
    public void updateUser(A3User a3User) {
        a3Repo.updateUser(a3User);
    }

    @Override
    public void deleteUser(String id) {
        a3Repo.deleteUser(id);
    }
}
