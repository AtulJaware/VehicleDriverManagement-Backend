package com.vehicle_driver_management.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vehicle_driver_management.app.entity.Driver;
import com.vehicle_driver_management.app.service.DriverService;

@RestController
@RequestMapping("/drivers")
@CrossOrigin(origins = "http://localhost:3000/")
public class DriverController {
	@Autowired
    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/add")
    public ResponseEntity<Driver> addDriver(@Valid @RequestBody Driver driver) {
        Driver savedDriver = driverService.addDriver(driver);
        return ResponseEntity.ok(savedDriver);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Driver> updateDriver(
            @PathVariable Long id,
            @Valid @RequestBody Driver driver) throws NotFoundException {
        Driver updatedDriver = driverService.updateDriver(id, driver);
        return ResponseEntity.ok(updatedDriver);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable Long id) throws NotFoundException {
        Driver driver = driverService.getDriverById(id);
        return ResponseEntity.ok(driver);
    }
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers(){
        return new ResponseEntity<List<Driver>>(driverService.getAllDrivers(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}
