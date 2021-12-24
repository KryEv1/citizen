package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.dto.A2UserDto;
import com.courses.assignment.citizen.repositories.A2Repo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("A2Users")
public class A2Controller {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private A2Repo repo;

    @GetMapping("")
    public ResponseEntity<?> getAllA2() {
        List<A2UserDto> a2Users = repo.getAll().stream().map(a2User -> modelMapper.map(a2User, A2UserDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(a2Users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getA2ByID(int id) {
        return ResponseEntity.ok(modelMapper.map(repo.getById(id), A2UserDto.class));
    }
}
