package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Province;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProvinceRepoImpl implements ProvinceRepo {
    @Override
    public List<Province> getAll() {
        return null;
    }

    @Override
    public Province getById(int id) {
        return null;
    }

    @Override
    public void update(Province province) {

    }

    @Override
    public void delete(int provinceID) {

    }
}
