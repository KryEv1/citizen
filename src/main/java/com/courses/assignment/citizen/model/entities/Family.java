package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Family {
    private String familyID;
    private String householderID;
    private Citizen householder;
    private String address;
    private String fullAddress;
    private List<Citizen> members;
}
