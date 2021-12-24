package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.District;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo {
    public List<District> getAllInProvince(int provinceID);
    public District getById(int id);
    public void update(District district);
    public void delete(int id);
}
