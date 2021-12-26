package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.dto.FamilyDto;
import com.courses.assignment.citizen.model.entities.Citizen;
import com.courses.assignment.citizen.model.entities.Family;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FamilyService {
    List<FamilyDto> getAllByProvince(String provinceID);
    List<FamilyDto> getAllByDistrict(String districtID);
    List<FamilyDto> getAllByCommune(String communeID);
    List<FamilyDto> getAllByHamlet(String hamletID);
    List<Citizen> getAllMembers(String familyID);
    Citizen getHouseholder(String familyID);
    FamilyDto getByID(String id);
    void add(Family family);
    void update(Family family);
    void delete(String familyID);
    String getAddress(String familyID);
}
