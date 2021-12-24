package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public ResponseEntity<?> getAllAccount() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountByID(@PathVariable int id) {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getAccountByEmail(@RequestParam String email) {
        return ResponseEntity.ok(accountService.getByEmail(email));
    }

    @PostMapping("/{id}/changePassword")
    public ResponseEntity<?> updatePassword(@PathVariable int id, @RequestBody String password) {
        accountService.updatePassword(password, id);
        return ResponseEntity.ok("Đổi mật khẩu thành công");
    }

    @PostMapping("/{id}/changeEmail")
    public ResponseEntity<?> updateEmail(@PathVariable int id, @RequestBody String email) {
        accountService.updateEmail(email, id);
        return ResponseEntity.ok("Đổi email thành công");
    }
}
