package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.entities.Province;
import com.courses.assignment.citizen.repositories.ProvinceRepo;
import com.courses.assignment.citizen.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepo provinceRepo;

    @Override
    public List<Province> getAll() {
        return provinceRepo.getAll();
    }

    @Override
    public Province getById(String id) {
        return provinceRepo.getById(id);
    }

    @Override
    public void add(Province province) {
        provinceRepo.add(province);
    }

    @Override
    public void update(Province province) {
        provinceRepo.update(province);
    }

    @Override
    public void delete(String provinceID) {
        provinceRepo.delete(provinceID);
    }
}
