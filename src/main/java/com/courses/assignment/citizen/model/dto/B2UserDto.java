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
public class B2UserDto implements Serializable {
    private Integer userID;
    private String name;
    private Date birth;
    private String phone;
    private Integer hamletID;
    private Integer b1UserID;
}
