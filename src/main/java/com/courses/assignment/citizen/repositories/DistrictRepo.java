package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.District;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo {
    List<District> getAllInProvince(String provinceID);
    District getById(String id);
    void add(District district);
    void update(District district);
    void delete(String id);
}
