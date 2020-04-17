package org.mmo.restaurantx.app.service.impl;

import org.mmo.restaurantx.app.domain.User;
import org.mmo.restaurantx.app.payload.LoginRequest;
import org.mmo.restaurantx.app.payload.response.AuthenticationResponse;
import org.mmo.restaurantx.app.repository.UserRepository;
import org.mmo.restaurantx.app.security.JwtUtil;
import org.mmo.restaurantx.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }
    
    public ResponseEntity<?> addNewCustomer(User user) {
        return ResponseEntity.ok("done");
    }
    
    public ResponseEntity<AuthenticationResponse> authenticateUser(LoginRequest authenticationRequest) {
        String userEmail = authenticationRequest.getEmail();
        String password = authenticationRequest.getPassword();
        AuthenticationResponse authenticationResponse = null;
        System.out.println(userEmail + " / " + password);
        if (userRepository.existsByEmailAndPassword(userEmail, password)) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEmail, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtil.generateToken(userEmail);
            
            authenticationResponse = new AuthenticationResponse(jwt);
            authenticationResponse.setSuccess(true);
            authenticationResponse.setMessage("Authenticated Successfully!");
        } else {
            authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setSuccess(false);
            authenticationResponse.setMessage("Invalid email or password!");
        }
        
        return ResponseEntity.ok(authenticationResponse);
    }
    
}
