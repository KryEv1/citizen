package com.courses.assignment.citizen.repositories.impl;

import com.courses.assignment.citizen.model.entities.Hamlet;
import com.courses.assignment.citizen.repositories.HamletRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HamletRepoImpl implements HamletRepo {
    @Override
    public List<Hamlet> getAllInProvince(int provinceID) {
        return null;
    }

    @Override
    public List<Hamlet> getAllInDistrict(int districtID) {
        return null;
    }

    @Override
    public List<Hamlet> getAllInCommune(int communeID) {
        return null;
    }

    @Override
    public Hamlet getByID(int id) {
        return null;
    }

    @Override
    public void update(Hamlet hamlet) {

    }

    @Override
    public void delete(int id) {

    }
}
