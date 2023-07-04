package com.vehicle_driver_management.app.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String registrationNumber;

    @NotBlank
    private String model;

    @NotBlank
    private String fuelType;

    private String isInsured;

    private String isInMaintenance;

    private String colour;

    private Integer seatingCapacity;

    @NotBlank
    private String engineNumber;

    @NotBlank
    private String vehicleType;

    
}
