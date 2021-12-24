package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class A2User extends User {
    private Integer id;
    private String userStatus;
    private Integer provinceID;
    private Integer a1Userid;
}