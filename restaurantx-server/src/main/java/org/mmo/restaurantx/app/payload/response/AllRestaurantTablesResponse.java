package org.mmo.restaurantx.app.payload.response;

import org.mmo.restaurantx.app.domain.RestaurantTable;

import java.util.List;

public class AllRestaurantTablesResponse extends ApiResponse {
    
    private List<RestaurantTable> tables;
    
    public AllRestaurantTablesResponse() {
    }
    
    public AllRestaurantTablesResponse(boolean success, String message) {
        super(success, message);
    }
    
    public List<RestaurantTable> getTables() {
        return tables;
    }
    
    public void setTables(List<RestaurantTable> tables) {
        this.tables = tables;
    }
}
