package org.mmo.restaurantx.app.payload.response;

import org.mmo.restaurantx.app.domain.Reservation;

import java.util.Set;

public class ReservationsByDateResponse extends ApiResponse {
    
    private Set<Reservation> reservations;
    
    public ReservationsByDateResponse() {
    }
    
    public ReservationsByDateResponse(boolean success, String message) {
        super(success, message);
    }
    
    public Set<Reservation> getReservations() {
        return reservations;
    }
    
    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
    
}
