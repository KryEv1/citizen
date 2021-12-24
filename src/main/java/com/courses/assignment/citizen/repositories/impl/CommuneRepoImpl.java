package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.entities.Commune;
import com.courses.assignment.citizen.repositories.CommuneRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommuneRepoImpl implements CommuneRepo {
    @Override
    public List<Commune> getAllInProvince(int provinceID) {
        return null;
    }

    @Override
    public List<Commune> getAllInDistrict(int districtID) {
        return null;
    }

    @Override
    public Commune getById(int id) {
        return null;
    }

    @Override
    public void update(Commune commune) {

    }

    @Override
    public void delete(int id) {

    }
}
