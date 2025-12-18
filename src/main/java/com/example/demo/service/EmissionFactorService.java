package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;

import java.util.List;

public interface EmissionFactorService {

    EmissionFactor createFactor(EmissionFactor factor);

    EmissionFactor getFactor(Long id);

    List<EmissionFactor> getAllFactors();
}
