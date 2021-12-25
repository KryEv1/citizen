package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Citizen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepo {
    List<Citizen> getAllByProvince(int provinceID);
    List<Citizen> getAllByDistrict(int districtID);
    List<Citizen> getAllByCommune(int communeID);
    List<Citizen> getAllByHamlet(int hamletID);
    List<Citizen> getAllInFamily(int familyID);
    Citizen findByID(int id);
    void updateInfo(Citizen citizen);
    void delete(int id);
}
