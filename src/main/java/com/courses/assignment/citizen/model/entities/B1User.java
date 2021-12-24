package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class B1User extends User {
    private Integer id;
    private String userStatus;
    private Integer communeID;
    private Integer a3Userid;
}