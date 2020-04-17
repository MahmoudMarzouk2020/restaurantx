package org.mmo.restaurantx.app.service;

import org.mmo.restaurantx.app.payload.response.ReservationsByDateResponse;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    
    ResponseEntity<ReservationsByDateResponse> getReservationsByDate(String dateOfReservations);
    
}
