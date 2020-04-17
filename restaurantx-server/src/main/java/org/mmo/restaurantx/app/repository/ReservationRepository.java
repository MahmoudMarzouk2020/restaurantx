package org.mmo.restaurantx.app.repository;

import org.mmo.restaurantx.app.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
    Set<Reservation> findAllByStartLessThanEqualAndEndGreaterThanEqual(LocalDateTime startDateTime, LocalDateTime endDateTime);
    
    Set<Reservation> findAllByStartBetween(LocalDateTime dayStart, LocalDateTime dayEnd);
    
}
