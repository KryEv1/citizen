package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Commune;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneRepo {
    List<Commune> getAllInProvince(String provinceID);
    List<Commune> getAllInDistrict(String districtID);
    Commune getById(String id);
    void add(Commune commune);
    void update(Commune commune);
    void delete(String id);
}
