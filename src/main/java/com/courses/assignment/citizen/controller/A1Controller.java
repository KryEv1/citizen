package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.dto.A1UserDto;
import com.courses.assignment.citizen.model.register.A1Register;
import com.courses.assignment.citizen.services.A1Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("A1Users")
public class A1Controller {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private A1Service a1Service;

    @GetMapping("")
    public ResponseEntity<?> getAllA1() {
        return ResponseEntity.ok(a1Service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getA1ByID(int id) {
        return ResponseEntity.ok(modelMapper.map(a1Service.getById(id), A1UserDto.class));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody A1Register register) {
        a1Service.createUser(register);
        return ResponseEntity.ok("Tạo người dùng thành công");
    }

}
