package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class ActivityLogController {

    private final ActivityLogService logService;

    public ActivityLogController(ActivityLogService logService) {
        this.logService = logService;
    }

    @PostMapping("/{userId}/{typeId}")
    public ActivityLog log(@PathVariable Long userId,
                           @PathVariable Long typeId,
                           @RequestBody ActivityLog log) {
        return logService.logActivity(userId, typeId, log);
    }

    @GetMapping("/{id}")
    public ActivityLog get(@PathVariable Long id) {
        return logService.getLog(id);
    }

    @GetMapping("/user/{userId}")
    public List<ActivityLog> getByUser(@PathVariable Long userId) {
        return logService.getLogsByUser(userId);
    }

    @GetMapping("/user/{userId}/range")
    public List<ActivityLog> getByUserAndDate(
            @PathVariable Long userId,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return logService.getLogsByUserAndDate(userId, start, end);
    }
}
