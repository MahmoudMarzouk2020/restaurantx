package org.mmo.restaurantx.app.controller;

import org.mmo.restaurantx.app.domain.RestaurantTable;
import org.mmo.restaurantx.app.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/cust")
public class CustomerController {
    
    private CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping("/show-available-tables")
    public List<RestaurantTable> showAllAvailableTables() {
        return customerService.getAvailableTablesByDateTimeAndPersonsNumber(LocalDateTime.now(), 3);
    }
    
}
