package com.courses.assignment.citizen.services;

import com.courses.assignment.citizen.model.entities.Province;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceService {
    List<Province> getAll();
    Province getById(int id);
    void add(Province province);
    void update(Province province);
    void delete(int provinceID);
}
