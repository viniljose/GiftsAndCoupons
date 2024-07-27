package org.giftsncoupons.promotion.api.controllers;

import org.giftsncoupons.promotion.services.giftallocation.GiftAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
    @Autowired
    private  GiftAllocationService giftAllocationService;

    @PostMapping("/allocate-gifts")
    public ResponseEntity<Void> allocateGifts(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        System.out.println("------allocateGifts-------");
        giftAllocationService.allocateGiftsForPurchases(date);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/available")
    public ResponseEntity<Long> availableGifts(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok().body(giftAllocationService.availableGifts(date));
    }

    @GetMapping("/allocated")
    public ResponseEntity<Long> allocatedGifts(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok().body(giftAllocationService.allocatedGifts(date));
    }


}
