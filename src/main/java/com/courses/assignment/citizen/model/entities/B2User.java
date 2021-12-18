package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "b2_user")
public class B2User {
    @Id
    @Column(name = "userID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "user_status", nullable = false)
    private String userStatus;

    @Column(name = "hamletID", nullable = false)
    private Integer hamletID;

    @Column(name = "b1_userID")
    private Integer b1Userid;
}