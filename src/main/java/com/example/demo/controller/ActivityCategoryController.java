package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService service;

    public ActivityCategoryController(ActivityCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityCategory createCategory(
            @RequestBody ActivityCategory category) {
        return service.createCategory(category);
    }

    @GetMapping("/{id}")
    public ActivityCategory getCategory(@PathVariable Long id) {
        return service.getCategory(id);
    }

    @GetMapping
    public List<ActivityCategory> getAllCategories() {
        return service.getAllCategories();
    }
}
