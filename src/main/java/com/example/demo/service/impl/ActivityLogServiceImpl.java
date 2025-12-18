package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

        if (log.getQuantity() <= 0) return null;

        if (log.getActivityDate().isAfter(LocalDate.now())) return null;

        // 🔥 List return aagudhu
        List<EmissionFactor> factors =
                factorRepo.findByActivityTypeId(
                        log.getActivityType().getId()
                );

        if (factors.isEmpty()) return null;

        EmissionFactor factor = factors.get(0);

        double emission = log.getQuantity() * factor.getFactor();


        log.setEstimatedEmission(emission);

        return logRepo.save(log);
    }
}
