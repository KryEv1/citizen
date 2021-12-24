package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<AccountDto> getAll();
    AccountDto getById(int id);
    AccountDto getByEmail(String email);
    void updatePassword(String password, int id);
    void updateEmail(String email, int id);
    boolean checkEmail(String email);
    boolean checkUsername(String username);
}
