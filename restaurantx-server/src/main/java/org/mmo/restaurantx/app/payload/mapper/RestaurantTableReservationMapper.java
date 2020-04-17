package org.mmo.restaurantx.app.payload.mapper;

import org.mmo.restaurantx.app.domain.Reservation;
import org.mmo.restaurantx.app.payload.request.RestaurantTableReservationRequest;
import org.mmo.restaurantx.app.repository.RestaurantTableRepository;
import org.mmo.restaurantx.app.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class RestaurantTableReservationMapper implements ModelRequestMapper<Reservation, RestaurantTableReservationRequest> {
    
    private final UserRepository userRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    
    public RestaurantTableReservationMapper(UserRepository userRepository, RestaurantTableRepository restaurantTableRepository) {
        this.userRepository = userRepository;
        this.restaurantTableRepository = restaurantTableRepository;
    }
    
    @Override
    public Reservation fromRequestToModel(RestaurantTableReservationRequest request) {
        Reservation reservation = new Reservation();
    
        reservation.setCustomer(userRepository.getOne(request.getCustomerId()));
        reservation.setTable(restaurantTableRepository.getOne(request.getRestaurantTableId()));
        reservation.setStart(request.getStart());
        reservation.setEnd(request.getEnd());
        reservation.setNoOfPersons(request.getNoOfPersons());
        
        return reservation;
    }
    
}
