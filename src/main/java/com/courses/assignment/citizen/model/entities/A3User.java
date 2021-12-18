package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "a3_user")
public class A3User {
    @Id
    @Column(name = "userID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "user_status", nullable = false)
    private String userStatus;

    @Column(name = "districtID", nullable = false)
    private Integer districtID;

    @Column(name = "a2_userID", nullable = false)
    private Integer a2Userid;
}