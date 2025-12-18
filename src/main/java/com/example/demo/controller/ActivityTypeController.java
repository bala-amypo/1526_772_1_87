package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityType createType(@RequestBody ActivityType type) {
        return service.createType(type);
    }

    @GetMapping("/{id}")
    public ActivityType getType(@PathVariable Long id) {
        return service.getType(id);
    }

    @GetMapping
    public List<ActivityType> getAllTypes() {
        return service.getAllTypes();
    }
}
