package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.dto.AccountDto;
import com.courses.assignment.citizen.model.entities.Account;
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
    ModelMapper modelMapper;
}
