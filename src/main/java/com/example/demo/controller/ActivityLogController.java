package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity-logs")
public class ActivityLogController {

    private final ActivityLogService service;

    public ActivityLogController(ActivityLogService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityLog createLog(@RequestBody ActivityLog log) {
        return service.createLog(log);
    }

    @GetMapping("/{id}")
    public ActivityLog getLog(@PathVariable Long id) {
        return service.getLog(id);
    }

    @GetMapping
    public List<ActivityLog> getAllLogs() {
        return service.getAllLogs();
    }
}
