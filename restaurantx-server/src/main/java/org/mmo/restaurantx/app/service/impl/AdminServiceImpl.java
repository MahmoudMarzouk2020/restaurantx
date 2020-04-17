package org.mmo.restaurantx.app.service.impl;

import org.mmo.restaurantx.app.domain.Reservation;
import org.mmo.restaurantx.app.payload.response.ReservationsByDateResponse;
import org.mmo.restaurantx.app.repository.ReservationRepository;
import org.mmo.restaurantx.app.repository.RestaurantTableRepository;
import org.mmo.restaurantx.app.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {
    
    private final ReservationRepository reservationRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    
    public AdminServiceImpl(ReservationRepository reservationRepository, RestaurantTableRepository restaurantTableRepository) {
        this.reservationRepository = reservationRepository;
        this.restaurantTableRepository = restaurantTableRepository;
    }
    
    @Override
    public ResponseEntity<ReservationsByDateResponse> getReservationsByDate(String dateOfReservations) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(dateOfReservations, formatter);
        LocalDateTime dayStart = LocalDateTime.of(parsedDate, LocalTime.of(0, 0, 0));
        LocalDateTime dayEnd = LocalDateTime.of(parsedDate, LocalTime.of(23, 59, 59));
        Set<Reservation> reservations = reservationRepository.findAllByStartBetween(dayStart, dayEnd);
        
        ReservationsByDateResponse reservationsByDateResponse = new ReservationsByDateResponse(true, "Reservations for day " + dateOfReservations.toString() + " has been fetched successfully!");
        reservationsByDateResponse.setReservations(reservations);
        
        return ResponseEntity.ok(reservationsByDateResponse);
    }
    
}
