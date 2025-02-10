package com.example.cache.service;

import com.example.cache.entity.Department;
import com.example.cache.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    /* @Override
     public Department departmentById(Integer id) {
         return departmentRepository.findById(id).orElse(null);
     }*/

    /*@Override
    @Cacheable(value = "departmentCache", key = "#id")
    public Department departmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }*/

    @Override
    @Cacheable(value = "applicationCache", key = "#id")
    public Department departmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    @CacheEvict(value = "applicationCache", allEntries = true)
    public void  clearAllCache() {
        System.out.println("******Cache Evict*********");
    }

    @CacheEvict(value = "applicationCache", key = "#id")
    @Override
    public void  clearAllCacheById(Integer id) {
        System.out.println("******Cache Evict *********"+id);
    }
    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }
}
