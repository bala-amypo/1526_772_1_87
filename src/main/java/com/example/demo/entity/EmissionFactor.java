// src/main/java/com/example/demo/entity/EmissionFactor.java
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;      // Example field
    private Double factor;    // Example field

    // Constructors
    public EmissionFactor() {}
    
    public EmissionFactor(String name, Double factor) {
        this.name = name;
        this.factor = factor;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getFactor() { return factor; }
    public void setFactor(Double factor) { this.factor = factor; }
}
