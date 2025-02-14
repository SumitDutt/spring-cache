package com.example.cache.controller;


import com.example.cache.service.CaffineCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CaffineCacheController {

    @Autowired
    private CaffineCacheService redisCacheService;

    @GetMapping("/areaOfSquare")
    public ResponseEntity<Double> areaofSquare(@RequestParam int side) {
        return ResponseEntity.ok(redisCacheService.areaOfSquare(side));
    }

    @GetMapping(path = "/evict")
    public ResponseEntity<String> evictCache() {
        redisCacheService.clearCache();
        return ResponseEntity.ok("Cache successfully clean");
    }

}