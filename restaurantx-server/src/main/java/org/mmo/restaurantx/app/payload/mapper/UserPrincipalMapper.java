package org.mmo.restaurantx.app.payload.mapper;

import org.mmo.restaurantx.app.domain.Role;
import org.mmo.restaurantx.app.domain.User;
import org.mmo.restaurantx.app.security.UserPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class UserPrincipalMapper {
    
    public static UserPrincipal mapFromUserToUserPrincipal(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getUserRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().name()));
        }
        return new UserPrincipal(user.getUserId(), user.getEmail(),
                user.getMobileNumber(), user.getPassword(), user.getFirstName(),
                user.getLastName(), authorities);
    }
    
}
