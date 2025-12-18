package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.User;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ActivityLogService;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository logRepo;
    private final UserRepository userRepo;
    private final ActivityTypeRepository typeRepo;

    public ActivityLogServiceImpl(ActivityLogRepository logRepo,
                                  UserRepository userRepo,
                                  ActivityTypeRepository typeRepo) {
        this.logRepo = logRepo;
        this.userRepo = userRepo;
        this.typeRepo = typeRepo;
    }

    @Override
    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {
        User user = userRepo.findById(userId).orElse(null);
        ActivityType type = typeRepo.findById(typeId).orElse(null);

        if (user != null && type != null) {
            log.setUser(user);
            log.setActivityType(type);
            return logRepo.save(log);
        }
        return null;
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return logRepo.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) {
        return logRepo.findByUserIdAndDateBetween(userId, start, end);
    }

    @Override
    public ActivityLog getLog(Long id) {
        return logRepo.findById(id).orElse(null);
    }
}
