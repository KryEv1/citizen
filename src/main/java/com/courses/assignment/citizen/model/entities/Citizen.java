package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "citizen")
public class Citizen {
    @Id
    @Column(name = "citizenID", nullable = false, length = 12)
    private String id;

    @Column(name = "full_name", nullable = false, length = 200)
    private String fullName;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Lob
    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "nationality", nullable = false, length = 100)
    private String nationality;

    @Column(name = "address", nullable = false)
    private Integer address;
}