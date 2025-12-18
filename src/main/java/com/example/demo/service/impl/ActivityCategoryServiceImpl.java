package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl
        implements ActivityCategoryService {

    private final ActivityCategoryRepository repo;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {

        // Optional: extra safety for uniqueness
        repo.findByCategoryName(category.getCategoryName())
            .ifPresent(c -> {
                throw new RuntimeException("Category name already exists");
            });

        return repo.save(category);
    }

    @Override
    public ActivityCategory getCategory(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return repo.findAll();
    }
}
