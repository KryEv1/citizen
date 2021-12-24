package com.courses.assignment.citizen.repositories;

import com.courses.assignment.citizen.model.entities.Province;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepo {
    public List<Province> getAll();
    public Province getById(int id);
    public void update(Province province);
    public void delete(int provinceID);
}
