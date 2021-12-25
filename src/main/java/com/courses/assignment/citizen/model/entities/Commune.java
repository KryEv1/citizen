package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Commune {
    private String id;
    private String communeName;
    private Integer population;
    private Integer totalHamlets;
    private String districtID;
}