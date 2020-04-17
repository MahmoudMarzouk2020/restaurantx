package org.mmo.restaurantx.app.service;

import org.mmo.restaurantx.app.payload.request.CustomerRegistrationRequest;
import org.mmo.restaurantx.app.payload.request.LoginRequest;
import org.mmo.restaurantx.app.payload.response.ApiResponse;
import org.mmo.restaurantx.app.payload.response.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    
    ResponseEntity<ApiResponse> addNewCustomer(CustomerRegistrationRequest registrationRequest);
    
    ResponseEntity<AuthenticationResponse> authenticateUser(LoginRequest authenticationRequest);
    
}
