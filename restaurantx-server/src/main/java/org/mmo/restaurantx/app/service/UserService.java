package org.mmo.restaurantx.app.service;

import org.mmo.restaurantx.app.domain.User;
import org.mmo.restaurantx.app.payload.LoginRequest;
import org.mmo.restaurantx.app.payload.response.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    
    ResponseEntity<?> addNewCustomer(User user);
    
    ResponseEntity<AuthenticationResponse> authenticateUser(LoginRequest authenticationRequest);
    
}
