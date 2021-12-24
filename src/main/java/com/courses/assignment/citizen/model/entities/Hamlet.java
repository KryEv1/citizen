package com.courses.assignment.citizen.model.entities;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Hamlet {
    private Integer id;
    private String hamletName;
    private Integer population;
    private Integer communeID;
}