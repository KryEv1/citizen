package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.entities.Citizen;
import com.courses.assignment.citizen.repositories.CitizenRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CitizenRepoImpl implements CitizenRepo {
    @Override
    public List<Citizen> getAllByProvince(int provinceID) {
        return null;
    }

    @Override
    public List<Citizen> getAllByDistrict(int districtID) {
        return null;
    }

    @Override
    public List<Citizen> getAllByCommune(int communeID) {
        return null;
    }

    @Override
    public List<Citizen> getAllByHamlet(int hamletID) {
        return null;
    }

    @Override
    public List<Citizen> getAllInFamily(int familyID) {
        return null;
    }

    @Override
    public Citizen findByID(int id) {
        return null;
    }

    @Override
    public void updateInfo(Citizen citizen) {

    }

    @Override
    public void delete(int id) {

    }
}
