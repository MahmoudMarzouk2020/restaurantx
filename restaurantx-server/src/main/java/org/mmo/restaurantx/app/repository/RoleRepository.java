package org.mmo.restaurantx.app.repository;

import org.mmo.restaurantx.app.domain.Role;
import org.mmo.restaurantx.app.domain.lookup.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    Role getRoleByRoleName(RoleName roleName);
    
}
