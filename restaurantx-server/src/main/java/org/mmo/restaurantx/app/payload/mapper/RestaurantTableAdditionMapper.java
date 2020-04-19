package org.mmo.restaurantx.app.payload.mapper;

import org.mmo.restaurantx.app.domain.RestaurantTable;
import org.mmo.restaurantx.app.payload.request.RestaurantTableAdditionRequest;
import org.springframework.stereotype.Component;

@Component
public class RestaurantTableAdditionMapper implements ModelRequestMapper<RestaurantTable, RestaurantTableAdditionRequest> {
    
    @Override
    public RestaurantTable fromRequestToModel(RestaurantTableAdditionRequest request) {
        return new RestaurantTable(request.getTableNumber(),
                request.getTableDesc(),
                request.getMaxNoOfPersons());
    }
    
}
