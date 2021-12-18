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
@Table(name = "district")
public class District {
    @Id
    @Column(name = "districtID", nullable = false)
    private Integer id;

    @Column(name = "district_name", length = 100)
    private String districtName;

    @Column(name = "population")
    private Integer population;

    @Column(name = "totalCommunes")
    private Integer totalCommunes;

    @Column(name = "provinceID", nullable = false)
    private Integer provinceID;
}