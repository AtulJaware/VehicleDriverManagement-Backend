package com.vehicle_driver_management.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.vehicle_driver_management.app.entity.Vehicle;
import com.vehicle_driver_management.app.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService{
	@Autowired
    private VehicleRepository vehicleRepository;

	@Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) throws NotFoundException {
		Vehicle existingVehicle = getVehicleById(id);
        existingVehicle.setRegistrationNumber(updatedVehicle.getRegistrationNumber());
        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setFuelType(updatedVehicle.getFuelType());
        existingVehicle.setIsInsured(updatedVehicle.getIsInsured());
        existingVehicle.setIsInMaintenance(updatedVehicle.getIsInMaintenance());
        existingVehicle.setColour(updatedVehicle.getColour());
        existingVehicle.setSeatingCapacity(updatedVehicle.getSeatingCapacity());
        existingVehicle.setEngineNumber(updatedVehicle.getEngineNumber());
        existingVehicle.setVehicleType(updatedVehicle.getVehicleType());
        return vehicleRepository.save(existingVehicle);
	}

	@Override
	public void deleteVehicle(Long id) {
		 vehicleRepository.deleteById(id);
		
	}

	@Override
	public Vehicle getVehicleById(Long id) throws NotFoundException {
		return vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

    
}

