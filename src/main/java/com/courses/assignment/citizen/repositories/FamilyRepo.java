package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Citizen;
import com.courses.assignment.citizen.model.entities.Family;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepo {
    List<Family> getAllByProvince(String provinceID);
    List<Family> getAllByDistrict(String districtID);
    List<Family> getAllByCommune(String communeID);
    List<Family> getAllByHamlet(String hamletID);
    List<Citizen> getAllMembers(String familyID);
    Citizen getHouseholder(String familyID);
    Family getByID(String id);
    void add(Family family);
    void update(Family family);
    void delete(String familyID);
    String getAddress(String familyID);
}
