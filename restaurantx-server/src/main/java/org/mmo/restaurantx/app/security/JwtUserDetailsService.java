package org.mmo.restaurantx.app.security;

import org.mmo.restaurantx.app.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    
    private UserRepository userRepository;
    
    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //    public UserDetails loadUserByEmail(String userEmail) throws UserEmailNotFoundException {
    public UserDetails loadUserByEmail(String userEmail) throws UsernameNotFoundException {
        return loadUserByUsername(userEmail);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.mmo.restaurantx.app.domain.User userFromDb = userRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("No User found with email : " + username)
                );
        
        return new User(userFromDb.getEmail(), userFromDb.getPassword(), new ArrayList<>());
    }
}
