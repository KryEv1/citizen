package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "a1_user")
public class A1User {
    @Id
    @Column(name = "userID", nullable = false)
    private int id;

    @Lob
    @Column(name = "user_status", nullable = false)
    private String userStatus;

    @Column(name = "total_provinces", nullable = false)
    private Integer totalProvinces;
}