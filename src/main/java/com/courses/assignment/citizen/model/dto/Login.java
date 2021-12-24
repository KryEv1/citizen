package com.courses.assignment.citizen.model.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Login implements Serializable {
    private String username;
    private String password;
}
