package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.District;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistrictRepoImpl implements DistrictRepo {
    @Override
    public List<District> getAllInProvince(int provinceID) {
        return null;
    }

    @Override
    public District getById(int id) {
        return null;
    }

    @Override
    public void update(District district) {

    }

    @Override
    public void delete(int id) {

    }
}
