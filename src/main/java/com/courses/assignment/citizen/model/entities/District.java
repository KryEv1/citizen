package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class District {
    private Integer id;
    private String districtName;
    private Integer population;
    private Integer totalCommunes;
    private Integer provinceID;
}