package com.courses.assignment.citizen.model.register;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class B1Register extends UserRegister {
    private String communeID;
}
