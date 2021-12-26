package com.courses.assignment.citizen.services.impl;

import com.courses.assignment.citizen.model.dto.FamilyDto;
import com.courses.assignment.citizen.model.entities.Citizen;
import com.courses.assignment.citizen.model.entities.Family;
import com.courses.assignment.citizen.repositories.FamilyRepo;
import com.courses.assignment.citizen.services.FamilyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FamilyRepo familyRepo;

    @Override
    public List<FamilyDto> getAllByProvince(String provinceID) {
        return familyRepo.getAllByProvince(provinceID).stream()
                .map(family -> modelMapper.map(family, FamilyDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<FamilyDto> getAllByDistrict(String districtID) {
        return familyRepo.getAllByDistrict(districtID).stream()
                .map(family -> modelMapper.map(family, FamilyDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<FamilyDto> getAllByCommune(String communeID) {
        return familyRepo.getAllByCommune(communeID).stream()
                .map(family -> modelMapper.map(family, FamilyDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<FamilyDto> getAllByHamlet(String hamletID) {
        return familyRepo.getAllByHamlet(hamletID).stream()
                .map(family -> modelMapper.map(family, FamilyDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<Citizen> getAllMembers(String familyID) {
        return familyRepo.getAllMembers(familyID);
    }

    @Override
    public Citizen getHouseholder(String familyID) {
        return familyRepo.getHouseholder(familyID);
    }

    @Override
    public FamilyDto getByID(String id) {
        return modelMapper.map(familyRepo.getByID(id), FamilyDto.class);
    }

    @Override
    public void add(Family family) {
        familyRepo.add(family);
    }

    @Override
    public void update(Family family) {
        familyRepo.update(family);
    }

    @Override
    public void delete(String familyID) {
        familyRepo.delete(familyID);
    }

    @Override
    public String getAddress(String familyID) {
        return familyRepo.getAddress(familyID);
    }
}
