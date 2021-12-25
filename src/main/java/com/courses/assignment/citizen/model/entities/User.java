package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class User {
    private String id;
    private String name;
    private Date birth;
    private String phone;
    private int accountID;
}