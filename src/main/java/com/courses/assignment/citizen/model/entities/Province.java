package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Province {
    private String id;
    private String provinceName;
    private Integer population;
    private Integer totalDistricts;
}