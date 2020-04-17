package org.mmo.restaurantx.app.domain;

import java.time.LocalDateTime;

public class Reservation {
    private Long reservationId;
    private Long customerId;
    private Integer tableId;
    private LocalDateTime start;
    private LocalDateTime end;
    private int noOfPersons;
    
}
