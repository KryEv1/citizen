package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.entities.Commune;
import com.courses.assignment.citizen.repositories.CommuneRepo;
import com.courses.assignment.citizen.services.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommuneServiceImpl implements CommuneService {
    @Autowired
    private CommuneRepo communeRepo;

    @Override
    public List<Commune> getAllInProvince(String provinceID) {
        return communeRepo.getAllInProvince(provinceID);
    }

    @Override
    public List<Commune> getAllInDistrict(String districtID) {
        return communeRepo.getAllInDistrict(districtID);
    }

    @Override
    public Commune getById(String id) {
        return communeRepo.getById(id);
    }

    @Override
    public void add(Commune commune) {
        communeRepo.add(commune);
    }

    @Override
    public void update(Commune commune) {
        communeRepo.update(commune);
    }

    @Override
    public void delete(String id) {
        communeRepo.delete(id);
    }
}
