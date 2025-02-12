package com.example.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface EHCacheService {
    @Cacheable(value = "areaOfSquareCache", key = "#side")
    double areaOfSquare(int side);

    @CacheEvict(cacheNames = { "areaOfSquareCache" }, allEntries = true)
    void clearCache();
}
