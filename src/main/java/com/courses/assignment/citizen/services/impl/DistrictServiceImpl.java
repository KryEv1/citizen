package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.entities.District;
import com.courses.assignment.citizen.repositories.DistrictRepo;
import com.courses.assignment.citizen.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepo districtRepo;

    @Override
    public List<District> getAllInProvince(String provinceID) {
        return districtRepo.getAllInProvince(provinceID);
    }

    @Override
    public District getById(String id) {
        return districtRepo.getById(id);
    }

    @Override
    public void add(District district) {
        districtRepo.add(district);
    }

    @Override
    public void update(District district) {
        districtRepo.update(district);
    }

    @Override
    public void delete(String id) {
        districtRepo.delete(id);
    }
}
