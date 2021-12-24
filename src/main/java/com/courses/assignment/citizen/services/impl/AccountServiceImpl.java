package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.dto.AccountDto;
import com.courses.assignment.citizen.repositories.AccountRepo;
import com.courses.assignment.citizen.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public List<AccountDto> getAll() {
        return accountRepo.getAll().stream().map(account -> modelMapper.map(account, AccountDto.class)).collect(Collectors.toList());
    }

    @Override
    public AccountDto getById(int id) {
        return modelMapper.map(accountRepo.getById(id), AccountDto.class);
    }

    @Override
    public AccountDto getByEmail(String email) {
        return modelMapper.map(accountRepo.getByEmail(email), AccountDto.class);
    }

    @Override
    public void updatePassword(String password, int id) {
        accountRepo.updatePassword(password, id);
    }

    @Override
    public void updateEmail(String email, int id) {
        accountRepo.updateEmail(email, id);
    }

    @Override
    public boolean checkEmail(String email) {
        return accountRepo.checkEmail(email);
    }

    @Override
    public boolean checkUsername(String username) {
        return accountRepo.checkUsername(username);
    }
}
