package org.mmo.restaurantx.app.repository;

import org.mmo.restaurantx.app.domain.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Integer> {
    
    Set<RestaurantTable> findByTableIdNotInAndMaxNoOfPersonsGreaterThanEqual(Set<Integer> tablesIdsList, int noOfPersons);
    
}
