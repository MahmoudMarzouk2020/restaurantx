package org.mmo.restaurantx.app.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "user_id")
    @NotNull
    private User customer;
    
    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "table_id")
    @NotNull
    private RestaurantTable table;
    
    @NotNull
    private LocalDateTime start;
    
    private LocalDateTime end;
    
    @Column(name = "number_of_persons")
    @Min(1)
    private int noOfPersons;
    
    public Reservation() {
    }
    
    public Reservation(@NotNull User customer, @NotNull RestaurantTable table, @NotNull LocalDateTime start, LocalDateTime end, @Min(1) int noOfPersons) {
        this.customer = customer;
        this.table = table;
        this.start = start;
        this.end = end;
        this.noOfPersons = noOfPersons;
    }
    
    public Long getReservationId() {
        return reservationId;
    }
    
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    
    public User getCustomer() {
        return customer;
    }
    
    public void setCustomer(User customer) {
        this.customer = customer;
    }
    
    public RestaurantTable getTable() {
        return table;
    }
    
    public void setTable(RestaurantTable table) {
        this.table = table;
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
