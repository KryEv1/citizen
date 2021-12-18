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
@Table(name = "commune")
public class Commune {
    @Id
    @Column(name = "communeID", nullable = false)
    private Integer id;

    @Column(name = "commune_name", length = 100)
    private String communeName;

    @Column(name = "population")
    private Integer population;

    @Column(name = "totalHamlets")
    private Integer totalHamlets;

    @Column(name = "districtID", nullable = false)
    private Integer districtID;
}