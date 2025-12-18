package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository repo;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        return repo.save(category);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return repo.findAll();
    }

    @Override
    public ActivityCategory getCategory(Long id) {
        return repo.findById(id).orElse(null);
    }
}
