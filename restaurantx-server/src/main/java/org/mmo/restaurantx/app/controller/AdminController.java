package org.mmo.restaurantx.app.controller;

import org.mmo.restaurantx.app.payload.request.RestaurantTableAdditionRequest;
import org.mmo.restaurantx.app.payload.response.AllRestaurantTablesResponse;
import org.mmo.restaurantx.app.payload.response.ReservationsByDateResponse;
import org.mmo.restaurantx.app.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final AdminService adminService;
    
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @GetMapping("/reservations")
    public ResponseEntity<ReservationsByDateResponse> getReservationsByDate(@RequestParam String date) {
        return adminService.getReservationsByDate(date);
    }
    
    @GetMapping("/tables/all")
    public ResponseEntity<AllRestaurantTablesResponse> getAllRestaurantTables() {
        return adminService.getAllTables();
    }
    
    @PutMapping("/table/add")
    public ResponseEntity<?> addNewRestaurantTable(@RequestBody RestaurantTableAdditionRequest request) {
        return adminService.addNewTable(request);
    }
    
}
