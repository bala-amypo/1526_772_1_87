package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factors")
public class EmissionFactorController {

    private final EmissionFactorService service;

    public EmissionFactorController(EmissionFactorService service) {
        this.service = service;
    }

    @PostMapping
    public EmissionFactor createFactor(@RequestBody EmissionFactor factor) {
        return service.createFactor(factor);
    }

    @GetMapping("/{id}")
    public EmissionFactor getFactor(@PathVariable Long id) {
        return service.getFactor(id);
    }

    @GetMapping
    public List<EmissionFactor> getAllFactors() {
        return service.getAllFactors();
    }
}
