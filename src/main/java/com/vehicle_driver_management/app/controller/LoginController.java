package com.vehicle_driver_management.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle_driver_management.app.entity.Customer;
import com.vehicle_driver_management.app.entity.LoginRequest;
import com.vehicle_driver_management.app.entity.LoginResponse;
import com.vehicle_driver_management.app.exception.EmailNotFoundException;
import com.vehicle_driver_management.app.exception.LoginInvalidCredentialsException;
import com.vehicle_driver_management.app.service.CustomerService;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000/")
public class LoginController {
	@Autowired
    private CustomerService customerService;

    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/login")
	ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginDto) throws LoginInvalidCredentialsException{
		LoginResponse login= customerService.login(loginDto);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PatchMapping("/logout/{username}")
	ResponseEntity<LoginResponse> logout(@PathVariable("username") String username) throws EmailNotFoundException {
		LoginResponse resp = customerService.logout(username);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        String username = loginRequest.getUsername();
//        String password = loginRequest.getPassword();
//
//        Optional<Customer> optionalCustomer = customerService.getCustomerByUsername(username);
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            if (customer.getPassword().equals(password)) {
//                return ResponseEntity.ok("Login successful!");
//            }
//        }
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody @Validated Customer customer) throws EmailNotFoundException{
    	String username= customer.getUsername();
    	String password= customer.getPassword();
    	Optional<Customer> optionalCustomer = customerService.getCustomerByUsername(username);
    	if (optionalCustomer.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        customerService.createCustomer(customer);
        return ResponseEntity.ok("Registration successful!");
    }
}

