package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "a2_user")
public class A2User {
    @Id
    @Column(name = "userID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "user_status", nullable = false)
    private String userStatus;

    @Column(name = "provinceID", nullable = false)
    private Integer provinceID;

    @Column(name = "a1_userID", nullable = false)
    private int a1Userid;
}