package org.mmo.restaurantx.app.service;

import org.mmo.restaurantx.app.domain.RestaurantTable;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomerService {
    
    List<RestaurantTable> getAvailableTablesByDateTimeAndPersonsNumber(LocalDateTime dateTime, int numberOfPersons);
    
}
