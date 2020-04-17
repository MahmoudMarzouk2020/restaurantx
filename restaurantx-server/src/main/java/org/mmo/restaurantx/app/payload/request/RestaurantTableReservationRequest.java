package org.mmo.restaurantx.app.payload.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RestaurantTableReservationRequest {
    
    @NotNull
    private Long customerId;
    
    @NotNull
    private Integer restaurantTableId;
    
    @NotNull
    private LocalDateTime start;
    
    private LocalDateTime end;
    
    @Min(1)
    private int noOfPersons;
    
    public RestaurantTableReservationRequest() {
    }
    
    public RestaurantTableReservationRequest(@NotNull Long customerId, @NotNull Integer restaurantTableId, @NotNull LocalDateTime start, LocalDateTime end, @Min(1) int noOfPersons) {
        this.customerId = customerId;
        this.restaurantTableId = restaurantTableId;
        this.start = start;
        this.end = end;
        this.noOfPersons = noOfPersons;
    }
    
    public Long getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    
    public Integer getRestaurantTableId() {
        return restaurantTableId;
    }
    
    public void setRestaurantTableId(Integer restaurantTableId) {
        this.restaurantTableId = restaurantTableId;
    }
    
    public LocalDateTime getStart() {
        return start;
    }
    
    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    
    public LocalDateTime getEnd() {
        return end;
    }
    
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    
    public int getNoOfPersons() {
        return noOfPersons;
    }
    
    public void setNoOfPersons(int noOfPersons) {
        this.noOfPersons = noOfPersons;
    }
    
}
