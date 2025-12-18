package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository factorRepo;
    private final ActivityTypeRepository typeRepo;

    public EmissionFactorServiceImpl(EmissionFactorRepository factorRepo,
                                     ActivityTypeRepository typeRepo) {
        this.factorRepo = factorRepo;
        this.typeRepo = typeRepo;
    }

    @Override
    public EmissionFactor createFactor(Long typeId, EmissionFactor factor) {
        ActivityType type = typeRepo.findById(typeId).orElse(null);
        if (type != null) {
            factor.setActivityType(type);
            return factorRepo.save(factor);
        }
        return null;
    }

    @Override
    public EmissionFactor getFactor(Long id) {
        return factorRepo.findById(id).orElse(null);
    }

    @Override
    public EmissionFactor getFactorByType(Long typeId) {
        return factorRepo.findByActivityTypeId(typeId);
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return factorRepo.findAll();
    }
}
