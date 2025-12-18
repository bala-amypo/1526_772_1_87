package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissionFactorServiceImpl
        implements EmissionFactorService {

    private final EmissionFactorRepository repo;

    public EmissionFactorServiceImpl(EmissionFactorRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmissionFactor createFactor(EmissionFactor factor) {
        return repo.save(factor);
    }

    @Override
    public EmissionFactor getFactor(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return repo.findAll();
    }
}
