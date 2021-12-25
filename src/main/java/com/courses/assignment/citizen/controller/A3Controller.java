package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.register.A3Register;
import com.courses.assignment.citizen.services.A3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("A3Users")
public class A3Controller {

    @Autowired
    private A3Service a3Service;

    @GetMapping("") // localhost:8080/A3Users
    public ResponseEntity<?> getAllA3() {
        return ResponseEntity.ok(a3Service.getAll());
    }

    @GetMapping("/{id}") // localhost:8080/A3Users/{id}
    public ResponseEntity<?> getA3ByID(int id) {
        return ResponseEntity.ok(a3Service.getById(id));
    }

    @PostMapping("/register") // localhost:8080/A3Users/register --- include json in body
    public ResponseEntity<?> createUser(@RequestBody A3Register register) {
        a3Service.createUser(register);
        return ResponseEntity.ok("Tạo người dùng thành công");
    }

    @PostMapping("/deleteUser") // localhost:8080/A3Users/deleteUser?id={id}
    public ResponseEntity<?> deleteA3(@RequestParam int id) {
        a3Service.deleteUser(id);
        return ResponseEntity.ok("Xóa người dùng thành công");
    }
}
