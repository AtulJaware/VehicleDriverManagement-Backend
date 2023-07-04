package com.vehicle_driver_management.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle_driver_management.app.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}

