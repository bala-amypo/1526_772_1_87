package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {
    EmissionFactor createFactor(Long typeId, EmissionFactor factor);
    EmissionFactor getFactor(Long id);
    EmissionFactor getFactorByType(Long typeId);
    List<EmissionFactor> getAllFactors();
}
