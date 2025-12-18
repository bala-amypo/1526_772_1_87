package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ActivityCategory;

public interface ActivityCategoryService {
    ActivityCategory createCategory(ActivityCategory category);
    List<ActivityCategory> getAllCategories();
    ActivityCategory getCategory(Long id);
}
