package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.dto.A2UserDto;
import com.courses.assignment.citizen.model.entities.A2User;
import com.courses.assignment.citizen.model.register.A2Register;
import com.courses.assignment.citizen.repositories.A2Repo;
import com.courses.assignment.citizen.services.A2Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class A2ServiceImpl implements A2Service {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private A2Repo a2Repo;

    @Override
    public List<A2UserDto> getAll() {
        return a2Repo.getAll().stream().map(a2User -> modelMapper.map(a2User, A2UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public A2UserDto getById(String id) {
        return modelMapper.map(a2Repo.getById(id), A2UserDto.class);
    }

    @Override
    public void createUser(A2Register register) {
        a2Repo.createUser(register);
    }

    @Override
    public void updateUser(A2User a2User) {
        a2Repo.updateUser(a2User);
    }

    @Override
    public void deleteUser(String id) {
        a2Repo.deleteUser(id);
    }
}
