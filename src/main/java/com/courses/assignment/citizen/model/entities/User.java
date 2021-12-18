package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false)
    private Integer id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "phone", length = 45)
    private String phone;

    @Column(name = "accountID")
    private int accountID;
}