package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.register.A1Register;
import com.courses.assignment.citizen.model.register.A2Register;
import com.courses.assignment.citizen.services.A1Service;
import com.courses.assignment.citizen.services.A2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("A1Users")
public class A1Controller {

    @Autowired
    private A1Service a1Service;

    @Autowired
    private A2Service a2Service;

    @GetMapping("")
    public ResponseEntity<?> getAllA1() {
        return ResponseEntity.ok(a1Service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getA1ByID(@PathVariable int id) {
        return ResponseEntity.ok(a1Service.getById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody A1Register register) {
        a1Service.createUser(register);
        return ResponseEntity.ok("Tạo người dùng thành công");
    }
}
