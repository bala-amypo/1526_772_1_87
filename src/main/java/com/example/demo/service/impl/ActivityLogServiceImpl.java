package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository logRepo;
    private final EmissionFactorRepository factorRepo;

    public ActivityLogServiceImpl(ActivityLogRepository logRepo,
                                  EmissionFactorRepository factorRepo) {
        this.logRepo = logRepo;
        this.factorRepo = factorRepo;
    }

    @Override
    public ActivityLog createLog(ActivityLog log) {

        // Rule 1: quantity > 0
        if (log.getQuantity() == null || log.getQuantity() <= 0) {
            return null;
        }

        // Rule 2: activityDate cannot be future
        if (log.getActivityDate() == null ||
                log.getActivityDate().isAfter(LocalDate.now())) {
            return null;
        }

        // Rule 3: get emission factor using activityType
        EmissionFactor factor = factorRepo
                .findByActivityTypeId(log.getActivityType().getId())
                .orElse(null);

        if (factor == null) {
            return null;
        }

        // Rule 4: estimatedEmission = quantity * factorValue
        double emission = log.getQuantity() * factor.getFactorValue();
        log.setEstimatedEmission(emission);

        return logRepo.save(log);
    }

    @Override
    public ActivityLog getLog(Long id) {
        return logRepo.findById(id).orElse(null);
    }

    @Override
    public java.util.List<ActivityLog> getAllLogs() {
        return logRepo.findAll();
    }
}
