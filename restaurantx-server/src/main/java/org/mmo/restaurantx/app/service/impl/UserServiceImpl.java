package org.mmo.restaurantx.app.service.impl;

import org.mmo.restaurantx.app.domain.User;
import org.mmo.restaurantx.app.payload.mapper.CustomerRegistrationMapper;
import org.mmo.restaurantx.app.payload.mapper.UserPrincipalMapper;
import org.mmo.restaurantx.app.payload.request.CustomerRegistrationRequest;
import org.mmo.restaurantx.app.payload.request.LoginRequest;
import org.mmo.restaurantx.app.payload.response.ApiResponse;
import org.mmo.restaurantx.app.payload.response.AuthenticationResponse;
import org.mmo.restaurantx.app.repository.UserRepository;
import org.mmo.restaurantx.app.security.JwtUtil;
import org.mmo.restaurantx.app.security.UserPrincipal;
import org.mmo.restaurantx.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil tokenProvider;
    private final CustomerRegistrationMapper customerRegistrationMapper;
    
    public UserServiceImpl(UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           JwtUtil tokenProvider,
                           CustomerRegistrationMapper customerRegistrationMapper) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.customerRegistrationMapper = customerRegistrationMapper;
    }
    
    @Override
    public ResponseEntity<ApiResponse> addNewCustomer(CustomerRegistrationRequest registrationRequest) {
        if (userRepository.existsByEmail(registrationRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Email is already taken!"));
        }

        User user = customerRegistrationMapper.fromRequestToModel(registrationRequest);
        userRepository.save(user);

        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }
    
    @Override
    public ResponseEntity<AuthenticationResponse> authenticateUser(LoginRequest loginRequest) {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt);
            authenticationResponse.setSuccess(true);
            authenticationResponse.setMessage("Authenticated successfully");
            Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());
            userOptional.ifPresent(user -> {
                UserPrincipal userPrincipal = UserPrincipalMapper.mapFromUserToUserPrincipal(user);
                authenticationResponse.setUserPrincipal(userPrincipal);
            });
            return ResponseEntity.ok(authenticationResponse);

        } catch (BadCredentialsException badCredentialsException) {
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setSuccess(false);
            authenticationResponse.setMessage("Invalid email or password");
            return ResponseEntity.badRequest().body(authenticationResponse);
        }
    }
    
}
