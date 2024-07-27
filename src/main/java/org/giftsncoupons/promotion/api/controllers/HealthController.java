package org.giftsncoupons.promotion.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<String> checkHealth() {
        // Return OK status with a message
        return new ResponseEntity<>("Promotion Application is running", HttpStatus.OK);
    }
}