package org.mmo.restaurantx.app.controller;

import org.mmo.restaurantx.app.payload.request.CustomerRegistrationRequest;
import org.mmo.restaurantx.app.payload.request.LoginRequest;
import org.mmo.restaurantx.app.payload.response.AuthenticationResponse;
import org.mmo.restaurantx.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final UserService userService;
    
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return userService.authenticateUser(loginRequest);
    }
    
    @PutMapping("/register")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        return userService.addNewCustomer(customerRegistrationRequest);
    }
    
}
