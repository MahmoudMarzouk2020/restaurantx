package org.mmo.restaurantx.app.service.impl;

import org.mmo.restaurantx.app.domain.RestaurantTable;
import org.mmo.restaurantx.app.repository.RestaurantTableRepository;
import org.mmo.restaurantx.app.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private RestaurantTableRepository restaurantTableRepository;
    
    public CustomerServiceImpl(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }
    
    public List<RestaurantTable> getAvailableTablesByDateTimeAndPersonsNumber(LocalDateTime dateTime, int numberOfPersons) {
        return restaurantTableRepository.findAllByMaxNoOfPersonsIsGreaterThanEqual(numberOfPersons);
    }
    
}
