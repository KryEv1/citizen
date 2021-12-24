package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Family;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepo {
    public List<Family> getAllByProvince(int provinceID);
    public List<Family> getAllByDistrict(int districtID);
    public List<Family> getAllByCommune(int communeID);
    public List<Family> getAllByHamlet(int hamletID);
    public Family getByID(int id);
    public void update(Family family);
    public void delete(int familyID);
}
