package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.entities.Hamlet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HamletService {
    List<Hamlet> getAllInProvince(int provinceID);
    List<Hamlet> getAllInDistrict(int districtID);
    List<Hamlet> getAllInCommune(int communeID);
    Hamlet getByID(int id);
    void add(Hamlet hamlet);
    void update(Hamlet hamlet);
    void delete(int id);
}
