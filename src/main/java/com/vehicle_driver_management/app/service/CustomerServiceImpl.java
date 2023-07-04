package com.vehicle_driver_management.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle_driver_management.app.entity.Customer;
import com.vehicle_driver_management.app.entity.LoginRequest;
import com.vehicle_driver_management.app.entity.LoginResponse;
import com.vehicle_driver_management.app.exception.EmailNotFoundException;
import com.vehicle_driver_management.app.exception.LoginInvalidCredentialsException;
import com.vehicle_driver_management.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
    private CustomerRepository customerRepository;

	@Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerByUsername(String username) {
		return customerRepository.findByUsername(username);
	}
	
	@Override
	public LoginResponse login(LoginRequest loginRequest)throws LoginInvalidCredentialsException {
		Optional<Customer> dbLoginOpt = customerRepository.findByUsername(loginRequest.getUsername());

		if (dbLoginOpt.isPresent()) {
			// compare db password with user provided password
			// if password matching return credentials else throw exception
			Customer login = dbLoginOpt.get();
			if (login.getPassword().equals(loginRequest.getPassword())) {
				
				// if credentials matches, set loggedIn flag as true and save
				login.setLoggedIn(true);
				Customer updatedLogin = customerRepository.save(login);
				
				// convert Login to LoginRespDto Obj
				LoginResponse resDto = new LoginResponse();
				resDto.setUsername(login.getUsername());
				resDto.setPassword(login.getPassword());
				resDto.setLoggedIn(login.isLoggedIn());
				
				return resDto;
				
			} else {
				throw new LoginInvalidCredentialsException("Invalid credentials!");
			}
		} else {
			// throw exception if given email not present in the db.
			throw new LoginInvalidCredentialsException("User not found with email: "+loginRequest.getUsername());
		}
	}

	@Override
	public LoginResponse logout(String username) throws EmailNotFoundException {
		Optional<Customer> dbLoginOpt = customerRepository.findByUsername(username);
		if(dbLoginOpt.isPresent()) {
			// update isLoggedIn flag as false and save
			Customer login = dbLoginOpt.get();
			
			// Update flag to false and save
			login.setLoggedIn(false);
			Customer updatedLogin = customerRepository.save(login);
			
			// Convert Login obj to LoginRespDto
			LoginResponse resDto = new LoginResponse();
			
			resDto.setLoggedIn(false);
					
			// return LoginRespDto obj
			return resDto;
		} else {
			throw new EmailNotFoundException("User not found with email: "+username);
		}
	}
}
