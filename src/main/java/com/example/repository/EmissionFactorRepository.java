package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, Long> {
    // Add custom method used in ActivityLogServiceImpl
    List<EmissionFactor> findByActivityTypeId(Long activityTypeId);
}
