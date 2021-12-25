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
public class A1UserDto implements Serializable {
    private String userID;
    private String name;
    private Date birth;
    private String phone;
    private Integer totalProvinces;
}
