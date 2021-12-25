package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class A3User extends User {
    private String userStatus;
    private String districtID;
    private String a2Userid;
}