package com.courses.assignment.citizen.model.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class AccountDto implements Serializable {
    private Integer id;
    private String username;
    private String email;
}
