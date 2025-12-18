package com.example.demo.service;

import com.example.demo.entity.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    ActivityType createType(ActivityType type);

    ActivityType getType(Long id);

    List<ActivityType> getAllTypes();
}
