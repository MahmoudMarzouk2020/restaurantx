package org.mmo.restaurantx.app.repository;

import org.mmo.restaurantx.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    boolean existsByEmailAndPassword(String email, String password);

}
