package com.courses.assignment.citizen.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provinceID", nullable = false)
    private Integer id;

    @Column(name = "province_name", length = 100)
    private String provinceName;

    @Column(name = "population")
    private Integer population;

    @Column(name = "totalDistricts")
    private Integer totalDistricts;
}