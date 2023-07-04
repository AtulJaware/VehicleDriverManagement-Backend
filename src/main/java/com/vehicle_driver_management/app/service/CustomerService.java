package com.vehicle_driver_management.app.service;
import java.util.Optional;

import com.vehicle_driver_management.app.entity.Customer;
import com.vehicle_driver_management.app.entity.LoginRequest;
import com.vehicle_driver_management.app.entity.LoginResponse;
import com.vehicle_driver_management.app.exception.EmailNotFoundException;
import com.vehicle_driver_management.app.exception.LoginInvalidCredentialsException;


public interface CustomerService {

	public LoginResponse login(LoginRequest loginRequest) throws LoginInvalidCredentialsException;
	public LoginResponse logout(String username) throws EmailNotFoundException;
	public Customer createCustomer(Customer customer);
	public Optional<Customer> getCustomerByUsername(String username);
}
