package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;

@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService categoryService;

    public ActivityCategoryController(ActivityCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ActivityCategory create(@RequestBody ActivityCategory category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<ActivityCategory> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ActivityCategory getById(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }
}
