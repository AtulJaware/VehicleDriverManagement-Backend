package com.vehicle_driver_management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.vehicle_driver_management.app.entity.Driver;
import com.vehicle_driver_management.app.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	 private DriverRepository driverRepository;
	    
	@Override
	public Driver addDriver(Driver driver) {
		 return driverRepository.save(driver);
	}

	@Override
	public Driver updateDriver(Long id, Driver updatedDriver) throws NotFoundException {
		 Driver existingDriver = getDriverById(id);
	        existingDriver.setName(updatedDriver.getName());
	        existingDriver.setPicture(updatedDriver.getPicture());
	        existingDriver.setDateOfBirth(updatedDriver.getDateOfBirth());
	        existingDriver.setAddress(updatedDriver.getAddress());
	        existingDriver.setContactNumber(updatedDriver.getContactNumber());
	        existingDriver.setAlternateContactNumber(updatedDriver.getAlternateContactNumber());
	        existingDriver.setDrivingLicenseNumber(updatedDriver.getDrivingLicenseNumber());
	        existingDriver.setDrivingLicenseExpiryDate(updatedDriver.getDrivingLicenseExpiryDate());
	        existingDriver.setEmail(updatedDriver.getEmail());
	        existingDriver.setAlternateEmail(updatedDriver.getAlternateEmail());
	        existingDriver.setEmergencyContactPerson(updatedDriver.getEmergencyContactPerson());
	        existingDriver.setEmergencyContactNumber(updatedDriver.getEmergencyContactNumber());
	        return driverRepository.save(existingDriver);
	}

	@Override
	public void deleteDriver(Long id) {
		driverRepository.deleteById(id);
		
	}

	@Override
	public Driver getDriverById(Long id) throws NotFoundException {
		 return driverRepository.findById(id)
	                .orElseThrow(() -> new NotFoundException());
	}

	@Override
	public List<Driver> getAllDrivers() {
		
		return driverRepository.findAll();
	}
}

