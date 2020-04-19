package org.mmo.restaurantx.app.service;

import org.mmo.restaurantx.app.domain.RestaurantTable;
import org.mmo.restaurantx.app.payload.request.RestaurantTableAdditionRequest;
import org.mmo.restaurantx.app.payload.response.AllRestaurantTablesResponse;
import org.mmo.restaurantx.app.payload.response.ApiResponse;
import org.mmo.restaurantx.app.payload.response.ReservationsByDateResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    
    ResponseEntity<ReservationsByDateResponse> getReservationsByDate(String dateOfReservations);
    
    ResponseEntity<AllRestaurantTablesResponse> getAllTables();
    
    ResponseEntity<ApiResponse> addNewTable(RestaurantTableAdditionRequest restaurantTableAdditionRequest);
    
}
