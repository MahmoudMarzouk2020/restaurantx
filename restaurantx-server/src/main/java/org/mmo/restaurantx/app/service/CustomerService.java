package org.mmo.restaurantx.app.service;

import org.mmo.restaurantx.app.payload.request.RestaurantTableReservationRequest;
import org.mmo.restaurantx.app.payload.response.AvailableRestaurantTablesResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    
    ResponseEntity<AvailableRestaurantTablesResponse> getAvailableTablesByDateTimeAndPersonsNumber(String dateTime, int numberOfPersons);
    
    ResponseEntity<?> reserveRestaurantTable(RestaurantTableReservationRequest reservationRequest);
    
}
