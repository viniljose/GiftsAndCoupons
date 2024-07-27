package org.giftsncoupons.promotion.domain.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
public class Purchase {
    private Long id;
    private Customer customer;
    private BigDecimal amount;
    private List<PurchaseItem> items;
    private LocalDate date;
    // getters and setters

    public void addItem(PurchaseItem item) {
        items.add(item);
        item.setPurchase(this);
        amount = amount.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
    }
}
