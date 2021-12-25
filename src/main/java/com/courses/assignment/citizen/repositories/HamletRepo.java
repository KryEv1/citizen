package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Hamlet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HamletRepo {
    List<Hamlet> getAllInProvince(String provinceID);
    List<Hamlet> getAllInDistrict(String districtID);
    List<Hamlet> getAllInCommune(String communeID);
    Hamlet getByID(String id);
    void add(Hamlet hamlet);
    void update(Hamlet hamlet);
    void delete(String id);
}
