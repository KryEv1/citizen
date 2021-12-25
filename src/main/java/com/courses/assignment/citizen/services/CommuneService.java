package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.entities.Commune;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommuneService {
    List<Commune> getAllInProvince(String provinceID);
    List<Commune> getAllInDistrict(String districtID);
    Commune getById(String id);
    void add(Commune commune);
    void update(Commune commune);
    void delete(String id);
}
