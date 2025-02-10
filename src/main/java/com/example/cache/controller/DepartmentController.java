package com.example.cache.controller;

import com.example.cache.entity.Department;
import com.example.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
        Department department = departmentService.departmentById(id);
        if (department != null)
            return new ResponseEntity<>(department, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/clearAllCache")
    public ResponseEntity<String> clearAllCache() {
        departmentService.clearAllCache();
        return new ResponseEntity<>("Clear All Cache", HttpStatus.OK);

    }
    @GetMapping("/clearAllCache/{id}")
    public ResponseEntity<String> clearAllCacheById(@PathVariable Integer id) {
        departmentService.clearAllCacheById(id);
        return new ResponseEntity<>("Clear All Cache", HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return new ResponseEntity<>("Add Job Succefully", HttpStatus.CREATED);

    }
}
