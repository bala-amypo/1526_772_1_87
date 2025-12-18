package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl
        implements ActivityTypeService {

    private final ActivityTypeRepository repo;

    public ActivityTypeServiceImpl(ActivityTypeRepository repo) {
        this.repo = repo;
    }

    @Override
    public ActivityType createType(ActivityType type) {
        return repo.save(type);
    }

    @Override
    public ActivityType getType(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ActivityType> getAllTypes() {
        return repo.findAll();
    }
}
