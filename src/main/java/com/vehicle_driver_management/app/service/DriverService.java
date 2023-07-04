package com.vehicle_driver_management.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.vehicle_driver_management.app.entity.Driver;

public interface DriverService {

	public Driver addDriver(Driver driver);
	public List<Driver> getAllDrivers();
	public Driver updateDriver(Long id, Driver updatedDriver) throws NotFoundException;
	public void deleteDriver(Long id);
	public Driver getDriverById(Long id) throws NotFoundException;
	 
}
