package org.giftsncoupons.promotion.api.controllers;

import org.giftsncoupons.promotion.services.giftallocation.GiftAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/promotions")
public class InitialisationController {

    @Autowired
    private GiftAllocationService giftAllocationService;

    @PostMapping("/init")
    public ResponseEntity<Void> init(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        giftAllocationService.init(date);
        return ResponseEntity.ok().build();
    }
}
