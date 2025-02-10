package com.example.cache.service;

import com.example.cache.entity.Department;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    Department departmentById(Integer id);


    void clearAllCache();


    void clearAllCacheById(Integer id);

    void addDepartment(Department department);
}
