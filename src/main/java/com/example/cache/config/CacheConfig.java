package com.example.cache.config;

import com.example.cache.entity.Department;
import com.example.cache.service.DepartmentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private DepartmentService departmentService;

    @PostConstruct
    public void preloadCache() {
        Cache cache = cacheManager.getCache("applicationCache");
        if (cache == null) {
            System.err.println("Cache not found: applicationCache");
            return;  // Exit if cache is not available
        }

        // Ensure departmentList is mutable
        List<Department> departmentList = new ArrayList<>(departmentService.findAll());

        // Correctly create and add new departments
        Department dep1 = new Department();
        dep1.setId(1);
        dep1.setName("CS");

        Department dep2 = new Department();
        dep2.setId(2);
        dep2.setName("Ele");

        departmentService.addDepartment(dep1);
        departmentService.addDepartment(dep2);
        departmentList.add(dep1);
        departmentList.add(dep2);

        // Populate cache
        for (Department department : departmentList) {
            cache.put(department.getId(), department);
        }

        System.out.println("Cache preloaded successfully!");
    }
    @Scheduled (fixedRate = 15000, initialDelay = 15000)
    public  void clearCache(){
        cacheManager.getCacheNames().parallelStream().forEach(name ->cacheManager.getCache(name).clear());
    }
}
