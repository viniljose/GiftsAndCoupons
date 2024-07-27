package org.giftsncoupons.promotion.domain.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
public class Promotion {
    private LocalDate date;
    private int maxGiftsPerDay;
    private BigDecimal minPurchaseAmount;
    private List<Gift> availableGifts;
    // getters and setters
}
