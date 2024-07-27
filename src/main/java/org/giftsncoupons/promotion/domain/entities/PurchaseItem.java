package org.giftsncoupons.promotion.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItem {
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private Purchase purchase;
    // getters and setters
}
