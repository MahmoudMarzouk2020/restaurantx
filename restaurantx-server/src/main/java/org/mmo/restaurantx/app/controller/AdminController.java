package org.mmo.restaurantx.app.controller;

import org.mmo.restaurantx.app.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final AdminService adminService;
    
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @PutMapping("/reservations")
    public ResponseEntity<?> getReservationsByDate(@RequestParam String date) {
        return adminService.getReservationsByDate(date);
    }
    
}
