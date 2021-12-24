package com.courses.assignment.citizen.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("A2Users")
public class A2Controller {

    @Autowired
    private ModelMapper modelMapper;
}
