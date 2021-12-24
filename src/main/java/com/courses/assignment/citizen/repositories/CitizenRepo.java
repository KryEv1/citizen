package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Citizen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepo {
    public List<Citizen> getAllByProvince(int provinceID);
    public List<Citizen> getAllByDistrict(int districtID);
    public List<Citizen> getAllByCommune(int communeID);
    public List<Citizen> getAllByHamlet(int hamletID);
    public List<Citizen> getAllInFamily(int familyID);
    public Citizen findByID(int id);
    public void updateInfo(Citizen citizen);
    public void delete(int id);
}
