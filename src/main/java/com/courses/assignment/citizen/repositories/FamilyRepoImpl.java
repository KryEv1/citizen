package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Family;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FamilyRepoImpl implements FamilyRepo {
    @Override
    public List<Family> getAllByProvince(int provinceID) {
        return null;
    }

    @Override
    public List<Family> getAllByDistrict(int districtID) {
        return null;
    }

    @Override
    public List<Family> getAllByCommune(int communeID) {
        return null;
    }

    @Override
    public List<Family> getAllByHamlet(int hamletID) {
        return null;
    }

    @Override
    public Family getByID(int id) {
        return null;
    }

    @Override
    public void update(Family family) {

    }

    @Override
    public void delete(int familyID) {

    }
}
