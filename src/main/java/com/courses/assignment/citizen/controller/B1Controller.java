package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.register.B1Register;
import com.courses.assignment.citizen.services.B1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("B1Users")
public class B1Controller {
    @Autowired
    private B1Service b1Service;

    @GetMapping("") // localhost:8080/B1Users
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(b1Service.getAll());
    }

    @GetMapping("/{id}") // localhost:8080/B1Users/{id}
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(b1Service.getById(id));
    }

    @PostMapping("/register") // localhost:8080/B1Users/register --- include json in body
    public  ResponseEntity<?> createUser(@RequestBody B1Register register) {
        b1Service.createUser(register);
        return ResponseEntity.ok("Tạo người dùng thành công");
    }

    @PostMapping("/deleteUser") // localhost:8080/B1Users/deleteUser?id={id}
    public ResponseEntity<?> delete(@RequestParam int id) {
        b1Service.deleteUser(id);
        return ResponseEntity.ok("Xóa người dùng thành công");
    }

}
