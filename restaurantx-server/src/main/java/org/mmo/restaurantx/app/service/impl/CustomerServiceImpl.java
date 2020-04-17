package org.mmo.restaurantx.app.service.impl;

import org.mmo.restaurantx.app.domain.Reservation;
import org.mmo.restaurantx.app.domain.RestaurantTable;
import org.mmo.restaurantx.app.payload.mapper.RestaurantTableReservationMapper;
import org.mmo.restaurantx.app.payload.request.RestaurantTableReservationRequest;
import org.mmo.restaurantx.app.payload.response.ApiResponse;
import org.mmo.restaurantx.app.payload.response.AvailableRestaurantTablesResponse;
import org.mmo.restaurantx.app.repository.ReservationRepository;
import org.mmo.restaurantx.app.repository.RestaurantTableRepository;
import org.mmo.restaurantx.app.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private final RestaurantTableRepository restaurantTableRepository;
    private final ReservationRepository reservationRepository;
    private final RestaurantTableReservationMapper restaurantTableReservationMapper;
    
    public CustomerServiceImpl(RestaurantTableRepository restaurantTableRepository,
                               ReservationRepository reservationRepository,
                               RestaurantTableReservationMapper restaurantTableReservationMapper) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.reservationRepository = reservationRepository;
        this.restaurantTableReservationMapper = restaurantTableReservationMapper;
    }
    
    @Override
    public ResponseEntity<AvailableRestaurantTablesResponse> getAvailableTablesByDateTimeAndPersonsNumber(String dateTime, int numberOfPersons) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime, formatter);
        
        Set<Reservation> reservations = reservationRepository.findAllByStartLessThanEqualAndEndGreaterThanEqual(parsedDateTime, parsedDateTime);
        Set<Integer> reservedTablesIds = reservations.stream().map(r -> r.getTable().getTableId()).collect(Collectors.toSet());
        Set<RestaurantTable> availableTables = restaurantTableRepository.findByTableIdNotInAndMaxNoOfPersonsGreaterThanEqual(reservedTablesIds, numberOfPersons);
        
        AvailableRestaurantTablesResponse availableRestaurantTablesResponse = new AvailableRestaurantTablesResponse(true, "Available tables fetched successfully!");
        availableRestaurantTablesResponse.setAvailableRestaurantTables(availableTables);
        
        return ResponseEntity.ok(availableRestaurantTablesResponse);
    }
    
    @Override
    public ResponseEntity<ApiResponse> reserveRestaurantTable(RestaurantTableReservationRequest reservationRequest) {
        Reservation reservation = restaurantTableReservationMapper.fromRequestToModel(reservationRequest);
        reservationRepository.save(reservation);
        return ResponseEntity.ok(new ApiResponse(true, "Table Number " + reservation.getTable().getTableNumber() + " has been reserved successfully!"));
    }
    
}
