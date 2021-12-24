package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Hamlet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HamletRepo {
    public List<Hamlet> getAllInProvince(int provinceID);
    public List<Hamlet> getAllInDistrict(int districtID);
    public List<Hamlet> getAllInCommune(int communeID);
    public Hamlet getByID(int id);
    public void update(Hamlet hamlet);
    public void delete(int id);
}
