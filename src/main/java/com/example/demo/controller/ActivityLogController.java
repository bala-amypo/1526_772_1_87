package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;

@RestController
@RequestMapping("/logs")
public class ActivityLogController {

    private final ActivityLogService logService;

    public ActivityLogController(ActivityLogService logService) {
        this.logService = logService;
    }

    @PostMapping("/{userId}/{typeId}")
    public ActivityLog logActivity(
            @PathVariable Long userId,
            @PathVariable Long typeId,
            @RequestBody ActivityLog log) {
        return logService.logActivity(userId, typeId, log);
    }

    @GetMapping("/user/{userId}")
    public List<ActivityLog> getByUser(@PathVariable Long userId) {
        return logService.getLogsByUser(userId);
    }

    @GetMapping("/{id}")
    public ActivityLog getById(@PathVariable Long id) {
        return logService.getLog(id);
    }

    @GetMapping("/user/{userId}/between")
    public List<ActivityLog> getByDate(
            @PathVariable Long userId,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return logService.getLogsByUserAndDate(userId, start, end);
    }
}
