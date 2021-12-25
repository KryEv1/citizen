package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Citizen {
    private String id;
    private String fullName;
    private Date birth;
    private String sex;
    private String nationality;
    private String address;
    private String fullAddress;
    private String householderID;
    private Citizen householder;
    private String relationship;
    private String familyID;
}