package com.vehicle_driver_management.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

	 private String username;
	 private String password;
	 private boolean isLoggedIn;
}
