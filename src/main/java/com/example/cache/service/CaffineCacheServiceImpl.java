package com.example.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
@CacheConfig(cacheNames = {"example"})
public class CaffineCacheServiceImpl implements CaffineCacheService {

    private final Logger LOG = LoggerFactory.getLogger(CaffineCacheServiceImpl.class);

    //@Cacheable(value = "areaOfSquareCache", key = "#side")
    @Cacheable
    public double areaOfSquare(int side) {
        LOG.info("Calculate the area of a SQUARE with a side of {}", side);
        return side * side;
    }

    //@CacheEvict(cacheNames = { "areaOfSquareCache" }, allEntries = true)
    @CacheEvict
    public void clearCache() {
        LOG.info("Clear Cache...");
    }
}
