package com.courses.assignment.citizen.model.dto;

import com.courses.assignment.citizen.model.entities.Citizen;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class FamilyDto implements Serializable {
    private String familyID;
    private Citizen householder;
    private String fullAddress;
    private List<Citizen> members;
}
