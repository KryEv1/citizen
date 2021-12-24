package com.courses.assignment.citizen.model.register;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class UserRegister {
    private Integer id;
    private String name;
    private Date birth;
    private String phone;
    private Integer accountID;
    private String username;
    private String password;
    private String email;
    private Integer supervisorID;
    private String userStatus;

}
