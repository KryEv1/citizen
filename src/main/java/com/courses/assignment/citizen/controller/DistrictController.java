package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.entities.District;
import com.courses.assignment.citizen.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping("/province") // localhost:8080/districts/province?provinceID={provinceID}
    public ResponseEntity<?> getAllInProvince(@RequestParam String provinceID) {
        return ResponseEntity.ok(districtService.getAllInProvince(provinceID));
    }

    @GetMapping("/{id}") // localhost:8080/districts/{id}
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(districtService.getById(id));
    }

    @PostMapping("/add") // localhost:8080/districts/add ---- include json in body
    public ResponseEntity<?> addDistrict(@RequestBody District district) {
        districtService.add(district);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PostMapping("/update") // localhost:8080/districts/update  ---- include json in body
    public ResponseEntity<?> updateDistrict(@RequestBody District district) {
        districtService.update(district);
        return ResponseEntity.ok("Cập nhật thông tin thành công");
    }

    @PostMapping("/delete") // localhost:8080/districts/delete?id={id}
    public ResponseEntity<?> delete(@RequestParam String id) {
        districtService.delete(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
