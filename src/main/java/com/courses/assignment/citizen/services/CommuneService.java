package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.entities.Commune;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommuneService {
    List<Commune> getAllInProvince(int provinceID);
    List<Commune> getAllInDistrict(int districtID);
    Commune getById(int id);
    void add(Commune commune);
    void update(Commune commune);
    void delete(int id);
}
