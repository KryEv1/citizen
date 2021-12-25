package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.entities.Commune;
import com.courses.assignment.citizen.services.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("communes")
public class CommuneController {
    @Autowired
    private CommuneService communeService;

    @GetMapping("/province") // locahost:8080/communes/province?provinceID={provinceID}
    public ResponseEntity<?> getAllByProvince(@RequestParam String provinceID) {
        return ResponseEntity.ok(communeService.getAllInProvince(provinceID));
    }

    @GetMapping("/province/district") // locahost:8080/communes/province/district?districtID={districtID}
    public ResponseEntity<?> getAllByDistrict(@RequestParam String districtID) {
        return ResponseEntity.ok(communeService.getAllInDistrict(districtID));
    }

    @GetMapping("/{id}") //  locahost:8080/communes/{id}
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(communeService.getById(id));
    }

    @PostMapping("/add") //  locahost:8080/communes/add --- include json in body
    public ResponseEntity<?> add(@RequestBody Commune commune) {
        communeService.add(commune);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PostMapping("/update") //  locahost:8080/communes/update ---- include json in body
    public ResponseEntity<?> update(@RequestBody Commune commune) {
        communeService.update(commune);
        return ResponseEntity.ok("Cập nhật thông tin thành công");
    }

    @PostMapping("/delete") // localhost:8080/communes/delete?id={id}
    public ResponseEntity<?> delete(@RequestParam String id) {
        communeService.delete(id);
        return ResponseEntity.ok("Xóa thành công");
    }

}
