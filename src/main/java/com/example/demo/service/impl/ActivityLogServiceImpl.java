package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository logRepo;
    private final UserRepository userRepo;
    private final ActivityTypeRepository typeRepo;
    private final EmissionFactorRepository factorRepo;

    public ActivityLogServiceImpl(ActivityLogRepository logRepo,
                                  UserRepository userRepo,
                                  ActivityTypeRepository typeRepo,
                                  EmissionFactorRepository factorRepo) {
        this.logRepo = logRepo;
        this.userRepo = userRepo;
        this.typeRepo = typeRepo;
        this.factorRepo = factorRepo;
    }

    @Override
    public ActivityLog logActivity(Long userId, Long activityTypeId, Double quantity, LocalDate date) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ActivityType type = typeRepo.findById(activityTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));

        EmissionFactor factor = factorRepo.findByActivityType_Id(activityTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));

        ActivityLog log = new ActivityLog();
        log.setUser(user);
        log.setActivityType(type);
        log.setQuantity(quantity);
        log.setActivityDate(date);
        log.setEstimatedEmission(quantity * factor.getFactorValue());

        return logRepo.save(log);
    }

    @Override
    public List<ActivityLog> getUserLogs(Long userId) {
        return logRepo.findByUser_Id(userId);
    }
}
