package com.courses.assignment.citizen.controller;

import com.courses.assignment.citizen.model.entities.Province;
import com.courses.assignment.citizen.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("provinces")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("") // localhost:8080/provinces
    public ResponseEntity<?> getAllProvince() {
        return ResponseEntity.ok(provinceService.getAll());
    }

    @GetMapping("/{id}") // localhost:8080/provinces/{id}
    public ResponseEntity<?> getProvinceById(@PathVariable int id) {
        return ResponseEntity.ok(provinceService.getById(id));
    }

    @PostMapping("/add") // /localhost:8080/provinces/add  --- them json vao body cua request
    public ResponseEntity<?> add(@RequestBody Province province) {
        provinceService.add(province);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PostMapping("/update") // /localhost:8080/provinces/update  --- them json vao body cua request
    public ResponseEntity<?> updateProvince(@RequestBody Province province) {
        provinceService.update(province);
        return ResponseEntity.ok("Cập nhật thông tin thành công");
    }

    @PostMapping("/delete") // localhost:8080/provinces/delete?id={id}
    public ResponseEntity<?> deleteProvince(@RequestParam int id) {
        provinceService.delete(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
