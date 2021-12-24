package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.dto.A3UserDto;
import com.courses.assignment.citizen.repositories.A3Repo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("A3Users")
public class A3Controller {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private A3Repo repo;

    @GetMapping("")
    public ResponseEntity<?> getAllA3() {
        List<A3UserDto> a3Users = repo.getAll().stream().map(a3User -> modelMapper.map(a3User, A3UserDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(a3Users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getA3ByID(int id) {
        return ResponseEntity.ok(modelMapper.map(repo.getById(id), A3UserDto.class));
    }

}
