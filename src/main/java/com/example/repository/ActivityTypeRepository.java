package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ActivityType;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {

    List<ActivityType> findByCategoryId(Long categoryId);
}
