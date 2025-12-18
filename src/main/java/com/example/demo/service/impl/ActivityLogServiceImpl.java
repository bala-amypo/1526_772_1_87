package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.EmissionFactorRepository;
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

        // quantity > 0
        if (log.getQuantity() <= 0) return null;

        // date not future
        if (log.getActivityDate().isAfter(LocalDate.now())) return null;

        // get emission factor
        EmissionFactor factor = factorRepo
                .findByActivityTypeId(log.getActivityType().getId())
                .orElse(null);

        if (factor == null) return null;

        // calculate emission
        double emission = log.getQuantity() * factor.getFactorValue();
        log.setEstimatedEmission(emission);

        return logRepo.save(log);
    }
}
