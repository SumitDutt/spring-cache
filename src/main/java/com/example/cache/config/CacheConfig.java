
package com.example.cache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching

public class CacheConfig {

@Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("example");
        caffeineCacheManager.setCaffeine(caffieCacheBuilder());
        return caffeineCacheManager;
    }

    private Caffeine<Object, Object> caffieCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(100).maximumSize(100)
                .expireAfterAccess(10, TimeUnit.MINUTES).recordStats();
    }


}

