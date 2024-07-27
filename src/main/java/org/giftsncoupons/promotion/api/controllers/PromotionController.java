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
public class PromotionController {
    @Autowired
    private  GiftAllocationService giftAllocationService;

  /*  public PromotionController(GiftAllocationService giftAllocationService) {
        this.giftAllocationService = giftAllocationService;
    }*/

    @PostMapping("/allocate-gifts")
    public ResponseEntity<Void> allocateGifts(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        giftAllocationService.allocateGiftsForPurchases(date);
        return ResponseEntity.ok().build();
    }
}
