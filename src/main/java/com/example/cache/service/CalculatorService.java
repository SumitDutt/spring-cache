package com.example.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface CalculatorService {
    @Cacheable(value = "areaOfSquareCache", condition = "#side > 5")
    double areaOfSquare(int side);

    @CacheEvict(cacheNames = { "areaOfSquareCache" }, allEntries = true)
    void clearCache();
}
