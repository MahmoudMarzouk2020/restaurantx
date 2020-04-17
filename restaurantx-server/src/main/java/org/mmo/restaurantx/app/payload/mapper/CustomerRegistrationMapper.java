package org.mmo.restaurantx.app.payload.mapper;

import org.mmo.restaurantx.app.domain.Role;
import org.mmo.restaurantx.app.domain.User;
import org.mmo.restaurantx.app.domain.lookup.RoleName;
import org.mmo.restaurantx.app.payload.request.CustomerRegistrationRequest;
import org.mmo.restaurantx.app.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomerRegistrationMapper implements ModelRequestMapper<User, CustomerRegistrationRequest> {
    
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    
    public CustomerRegistrationMapper(RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public User fromRequestToModel(CustomerRegistrationRequest request) {
        User user = new User();
        
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setMobileNumber(request.getMobileNumber());
        System.out.println("ORDINAL: " + RoleName.ROLE_CUSTOMER.ordinal());
        Role role = roleRepository.getRoleByRoleName(RoleName.ROLE_CUSTOMER);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setUserRoles(userRoles);
        
        return user;
    }
    
}
