package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService typeService;

    public ActivityTypeController(ActivityTypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping("/category/{categoryId}")
    public ActivityType create(
            @PathVariable Long categoryId,
            @RequestBody ActivityType type) {
        return typeService.createType(categoryId, type);
    }

    @GetMapping("/category/{categoryId}")
    public List<ActivityType> getByCategory(@PathVariable Long categoryId) {
        return typeService.getTypesByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public ActivityType getById(@PathVariable Long id) {
        return typeService.getType(id);
    }
}
