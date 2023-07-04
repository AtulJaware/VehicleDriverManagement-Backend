package com.vehicle_driver_management.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.vehicle_driver_management.app.annotation.AgeRange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String picture;

    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @AgeRange(min = 18, max = 65)
    private LocalDate dateOfBirth;

    @NotBlank
    private String address;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Contact number should be 10 digits")
    private String contactNumber;

    private String alternateContactNumber;

    @NotBlank
    private String drivingLicenseNumber;

    @NotNull
    private LocalDate drivingLicenseExpiryDate;

    @NotBlank
    @Email
    private String email;

    private String alternateEmail;

    @NotBlank
    private String emergencyContactPerson;

    @NotBlank
    private String emergencyContactNumber;

}
