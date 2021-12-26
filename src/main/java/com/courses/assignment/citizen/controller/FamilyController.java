package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("families")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @GetMapping("province")
    public ResponseEntity<?> getAllByProvince(@RequestParam String provinceID) {
        return ResponseEntity.ok(familyService.getAllByProvince(provinceID));
    }

    @GetMapping("/province/district")
    public ResponseEntity<?> getAllByDistrict(@RequestParam String districtID) {
        return ResponseEntity.ok(familyService.getAllByDistrict(districtID));
    }

    @GetMapping("/province/district/commune")
    public ResponseEntity<?> getAllByCommune(@RequestParam String communeID) {
        return ResponseEntity.ok(familyService.getAllByCommune(communeID));
    }

    @GetMapping("/province/district/commune/hamlet")
    public ResponseEntity<?> getAllByHamlet(@RequestParam String hamletID) {
        return ResponseEntity.ok(familyService.getAllByHamlet(hamletID));
    }

    @GetMapping("/family/members")
    public ResponseEntity<?> getMembers(@RequestParam String familyID) {
        return ResponseEntity.ok(familyService.getAllMembers(familyID));
    }

    @GetMapping("/family/householder")
    public ResponseEntity<?> getHouseholder(@RequestParam String familyID) {
        return ResponseEntity.ok(familyService.getHouseholder(familyID));
    }

    @GetMapping("/family/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(familyService.getByID(id));
    }

    @GetMapping("/family/address")
    public ResponseEntity<?> getAddress(@RequestParam String familyID) {
        return ResponseEntity.ok(familyService.getAddress(familyID));
    }
}
