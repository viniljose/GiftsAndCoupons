package org.giftsncoupons.promotion.domain.entities;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PurchaseItem {
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private Purchase purchase;
    // getters and setters
}
