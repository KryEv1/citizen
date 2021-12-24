package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Commune;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommuneRepo {
    public List<Commune> getAllInProvince(int provinceID);
    public List<Commune> getAllInDistrict(int districtID);
    public Commune getById(int id);
    public void update(Commune commune);
    public void delete(int id);
}
