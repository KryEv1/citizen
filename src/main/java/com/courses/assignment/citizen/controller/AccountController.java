package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.entities.Account;
import com.courses.assignment.citizen.model.entityManager.AccountManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {



    private final AccountManager accountManager = new AccountManager();

    @GetMapping("")
    public ResponseEntity<List<Account>> getAll() {
        List<Account> accounts = accountManager.getAll();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        return ResponseEntity.ok(accountManager.getById(id));
    }

}
