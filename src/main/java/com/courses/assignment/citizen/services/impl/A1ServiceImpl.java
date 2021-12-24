package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.dto.A1UserDto;
import com.courses.assignment.citizen.model.entities.A1User;
import com.courses.assignment.citizen.model.register.A1Register;
import com.courses.assignment.citizen.repositories.A1Repo;
import com.courses.assignment.citizen.services.A1Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class A1ServiceImpl implements A1Service {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private A1Repo a1Repo;

    @Override
    public List<A1UserDto> getAll() {
        return a1Repo.getAll().stream().map(a1User -> modelMapper.map(a1User, A1UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public A1UserDto getById(int id) {
        return modelMapper.map(a1Repo.getById(id), A1UserDto.class);
    }

    @Override
    public void createUser(A1Register register) {
        a1Repo.createUser(register);
    }

    @Override
    public void updateUser(A1User a1User) {
        a1Repo.updateUser(a1User);
    }

    @Override
    public void deleteUser(int id) {
        a1Repo.deleteUser(id);
    }
}
