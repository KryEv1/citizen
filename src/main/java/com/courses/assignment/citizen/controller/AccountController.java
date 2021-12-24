package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.dto.AccountDto;
import com.courses.assignment.citizen.repositories.AccountRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountRepo repo;

    @GetMapping("")
    public ResponseEntity<?> getAllAccount() {
        List<AccountDto> accounts = repo.getAll().stream().map(account -> modelMapper.map(account, AccountDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountByID(int id) {
        return ResponseEntity.ok(modelMapper.map(repo.getById(id), AccountDto.class));
    }

}
