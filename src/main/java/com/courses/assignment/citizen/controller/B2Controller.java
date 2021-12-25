package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.register.B2Register;
import com.courses.assignment.citizen.services.B2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("B2Users")
public class B2Controller {
    @Autowired
    private B2Service b2Service;

    @GetMapping("") // localhost:8080/B2Users
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(b2Service.getAll());
    }

    @GetMapping("/{id}") // localhost:8080/B2Users/{id}
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(b2Service.getById(id));
    }

    @PostMapping("/register") // localhost:8080/B2Users/register --- include json in body
    public ResponseEntity<?> createUser(@RequestBody B2Register register) {
        b2Service.createUser(register);
        return ResponseEntity.ok("Tạo người dùng thành công");
    }

    @PostMapping("/deleteUser") // localhost:8080/B2Users/deleteUser?id={id}
    public ResponseEntity<?> delete(@RequestParam String id) {
        b2Service.deleteUser(id);
        return ResponseEntity.ok("Xóa người dùng thành công");
    }
}
