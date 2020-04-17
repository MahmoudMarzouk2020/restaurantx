package org.mmo.restaurantx.app.payload.mapper;

public interface ModelRequestMapper<K, V> {
    
    K fromRequestToModel(V request);
    
}
