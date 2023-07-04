package com.vehicle_driver_management.app.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.vehicle_driver_management.app.entity.Vehicle;


public interface VehicleService {

	public Vehicle addVehicle(Vehicle vehicle);
	public List<Vehicle> getAllVehicles();
	public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) throws NotFoundException;
	public void deleteVehicle(Long id);
	public Vehicle getVehicleById(Long id) throws NotFoundException;
}
