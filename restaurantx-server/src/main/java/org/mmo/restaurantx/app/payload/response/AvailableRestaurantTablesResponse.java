package org.mmo.restaurantx.app.payload.response;

import org.mmo.restaurantx.app.domain.RestaurantTable;

import java.util.Set;

public class AvailableRestaurantTablesResponse extends ApiResponse {
    
    private Set<RestaurantTable> availableRestaurantTables;
    
    public AvailableRestaurantTablesResponse() {
    }
    
    public AvailableRestaurantTablesResponse(boolean success, String message) {
        super(success, message);
    }
    
    public Set<RestaurantTable> getAvailableRestaurantTables() {
        return availableRestaurantTables;
    }
    
    public void setAvailableRestaurantTables(Set<RestaurantTable> availableRestaurantTables) {
        this.availableRestaurantTables = availableRestaurantTables;
    }
}
