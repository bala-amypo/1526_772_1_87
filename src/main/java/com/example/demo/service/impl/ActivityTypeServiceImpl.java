package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ActivityType createActivityType(Long categoryId, ActivityType type) {
        ActivityCategory category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        type.setCategory(category);
        return typeRepo.save(type);
    }

    @Override
    public List<ActivityType> getByCategory(Long categoryId) {
        return typeRepo.findByCategory_Id(categoryId);
    }
}
