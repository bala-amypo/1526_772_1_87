package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {
    EmissionFactor addEmissionFactor(Long activityTypeId, EmissionFactor factor);
}
