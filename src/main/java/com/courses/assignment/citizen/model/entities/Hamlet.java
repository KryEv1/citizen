package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "hamlet")
public class Hamlet {
    @Id
    @Column(name = "hamletID", nullable = false)
    private Integer id;

    @Column(name = "hamlet_name", length = 100)
    private String hamletName;

    @Column(name = "population")
    private Integer population;

    @Column(name = "communeID", nullable = false)
    private Integer communeID;
}