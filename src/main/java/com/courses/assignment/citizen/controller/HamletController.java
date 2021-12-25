package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.entities.Hamlet;
import com.courses.assignment.citizen.services.HamletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hamlets")
public class HamletController {
    @Autowired
    private HamletService hamletService;

    @GetMapping("/province") // localhost:8080/hamlets/province?provinceID={provinceID}
    public ResponseEntity<?> getAllByProvince(@RequestParam int provinceID) {
        return ResponseEntity.ok(hamletService.getAllInProvince(provinceID));
    }

    @GetMapping("/province/district") // localhost:8080/hamlets/province/district?districtID={districtID}
    public ResponseEntity<?> getAllByDistrict(@RequestParam int districtID) {
        return ResponseEntity.ok(hamletService.getAllInDistrict(districtID));
    }

    @GetMapping("/province/district/commune") // localhost:8080/hamlets/province/district/commune?communeID={communeID}
    public ResponseEntity<?> getAllByCommune(@RequestParam int communeID) {
        return ResponseEntity.ok(hamletService.getAllInCommune(communeID));
    }

    @GetMapping("/{id}") // localhost:8080/hamlets/{id}
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(hamletService.getByID(id));
    }

    @PostMapping("/add") // localhost:8080/hamlets/add  --- include json in body
    public ResponseEntity<?> add(@RequestBody Hamlet hamlet) {
        hamletService.add(hamlet);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PostMapping("/update") // localhost:8080/hamlets/update --- include json in body
    public ResponseEntity<?> update(@RequestBody Hamlet hamlet) {
        hamletService.update(hamlet);
        return ResponseEntity.ok("Cập nhật thông tin thành công");
    }

    @PostMapping("/delete") // localhost:8080/hamlets/delete?id={id}
    public ResponseEntity<?> delete(@RequestParam int id) {
        hamletService.delete(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
