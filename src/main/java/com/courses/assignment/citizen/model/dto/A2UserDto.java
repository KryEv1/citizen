package com.courses.assignment.citizen.model.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class A2UserDto implements Serializable {
    private String id;
    private String name;
    private Date birth;
    private String phone;
    private String provinceID;
    private String a1Userid;
}
