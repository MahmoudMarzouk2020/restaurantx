package org.mmo.restaurantx.app.controller;

import org.mmo.restaurantx.app.payload.request.RestaurantTableReservationRequest;
import org.mmo.restaurantx.app.payload.response.AvailableRestaurantTablesResponse;
import org.mmo.restaurantx.app.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cust")
public class CustomerController {
    
    private final CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/available-tables")
    public ResponseEntity<AvailableRestaurantTablesResponse> showAllAvailableTables(@RequestParam String dateTime,
                                                                                    @RequestParam int persons) {
        return customerService.getAvailableTablesByDateTimeAndPersonsNumber(dateTime, persons);
    }
    
    @PutMapping("/reserve-table")
    public ResponseEntity<?> reserveRestaurantTable(@RequestBody RestaurantTableReservationRequest reservationRequest) {
        return customerService.reserveRestaurantTable(reservationRequest);
    }
    
}
