package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.register.A2Register;
import com.courses.assignment.citizen.services.A2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("A2Users")
public class A2Controller {

    @Autowired
    private A2Service a2Service;

    @GetMapping("")
    public ResponseEntity<?> getAllA2() {
        return ResponseEntity.ok(a2Service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getA2ByID(@PathVariable int id) {
        return ResponseEntity.ok(a2Service.getById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createA2(@RequestBody A2Register register) {
        a2Service.createUser(register);
        return ResponseEntity.ok("Tạo người dùng thành công");
    }
}
