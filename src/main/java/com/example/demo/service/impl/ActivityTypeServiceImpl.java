package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepo;
    private final ActivityCategoryRepository categoryRepo;

    public ActivityTypeServiceImpl(ActivityTypeRepository typeRepo,
                                   ActivityCategoryRepository categoryRepo) {
        this.typeRepo = typeRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public ActivityType createType(Long categoryId, ActivityType type) {
        ActivityCategory category = categoryRepo.findById(categoryId).orElse(null);
        if (category != null) {
            type.setCategory(category);
            return typeRepo.save(type);
        }
        return null;
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepo.findByCategoryId(categoryId);
    }

    @Override
    public ActivityType getType(Long id) {
        return typeRepo.findById(id).orElse(null);
    }
}
