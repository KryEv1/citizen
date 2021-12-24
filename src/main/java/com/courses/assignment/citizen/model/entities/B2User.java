package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class B2User extends User {
    private String userStatus;
    private Integer hamletID;
    private Integer b1Userid;
}