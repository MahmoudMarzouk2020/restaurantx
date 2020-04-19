package org.mmo.restaurantx.app.payload.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class RestaurantTableAdditionRequest {
    
    @NotBlank
    private String tableNumber;
    
    private String tableDesc;
    
    @Min(0)
    private int maxNoOfPersons;
    
    public RestaurantTableAdditionRequest() {
    }
    
    public RestaurantTableAdditionRequest(@NotBlank String tableNumber, String tableDesc, @Min(0) int maxNoOfPersons) {
        this.tableNumber = tableNumber;
        this.tableDesc = tableDesc;
        this.maxNoOfPersons = maxNoOfPersons;
    }
    
    public String getTableNumber() {
        return tableNumber;
    }
    
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }
    
    public String getTableDesc() {
        return tableDesc;
    }
    
    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }
    
    public int getMaxNoOfPersons() {
        return maxNoOfPersons;
    }
    
    public void setMaxNoOfPersons(int maxNoOfPersons) {
        this.maxNoOfPersons = maxNoOfPersons;
    }
    
}
