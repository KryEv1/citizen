package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.entities.Hamlet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HamletService {
    List<Hamlet> getAllInProvince(String provinceID);
    List<Hamlet> getAllInDistrict(String districtID);
    List<Hamlet> getAllInCommune(String communeID);
    Hamlet getByID(String id);
    void add(Hamlet hamlet);
    void update(Hamlet hamlet);
    void delete(String id);
}
