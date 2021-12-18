package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.entities.A1User;
import com.courses.assignment.citizen.model.entityManager.A1Manager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("a1users")
public class A1Controller {
    private final A1Manager a1Manager = new A1Manager();

    @GetMapping("")
    public ResponseEntity<List<A1User>> getAllA1User() {
        return ResponseEntity.ok(a1Manager.getAll());
    }
}
