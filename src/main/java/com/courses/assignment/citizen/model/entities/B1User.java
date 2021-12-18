package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "b1_user")
public class B1User {
    @Id
    @Column(name = "userID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "user_status", nullable = false)
    private String userStatus;

    @Column(name = "communeID", nullable = false)
    private Integer communeID;

    @Column(name = "a3_userID", nullable = false)
    private Integer a3Userid;
}