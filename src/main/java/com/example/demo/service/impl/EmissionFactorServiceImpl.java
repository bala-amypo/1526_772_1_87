package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

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
    public EmissionFactor addEmissionFactor(Long activityTypeId, EmissionFactor factor) {
        ActivityType type = typeRepo.findById(activityTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));
        factor.setActivityType(type);
        return factorRepo.save(factor);
    }
}
