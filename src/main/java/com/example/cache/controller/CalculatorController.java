package com.example.cache.controller;


import com.example.cache.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    private CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/areaOfSquare/{side}")
    public ResponseEntity<Double> areaofSquare(@PathVariable Integer  side) {
        return ResponseEntity.ok(calculatorService.areaOfSquare(side));
    }

    @GetMapping(path = "/evict")
    public ResponseEntity<String> evictCache() {
        calculatorService.clearCache();
        return ResponseEntity.ok("Cache successfully clean");
    }
}