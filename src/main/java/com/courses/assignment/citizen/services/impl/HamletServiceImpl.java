package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.entities.Hamlet;
import com.courses.assignment.citizen.repositories.HamletRepo;
import com.courses.assignment.citizen.services.HamletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HamletServiceImpl implements HamletService {
    @Autowired
    private HamletRepo hamletRepo;

    @Override
    public List<Hamlet> getAllInProvince(int provinceID) {
        return hamletRepo.getAllInProvince(provinceID);
    }

    @Override
    public List<Hamlet> getAllInDistrict(int districtID) {
        return hamletRepo.getAllInDistrict(districtID);
    }

    @Override
    public List<Hamlet> getAllInCommune(int communeID) {
        return hamletRepo.getAllInCommune(communeID);
    }

    @Override
    public Hamlet getByID(int id) {
        return hamletRepo.getByID(id);
    }

    @Override
    public void add(Hamlet hamlet) {
        hamletRepo.add(hamlet);
    }

    @Override
    public void update(Hamlet hamlet) {
        hamletRepo.update(hamlet);
    }

    @Override
    public void delete(int id) {
        hamletRepo.delete(id);
    }
}
