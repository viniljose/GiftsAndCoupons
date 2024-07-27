package org.giftsncoupons.promotion.domain.repositories;

import org.giftsncoupons.promotion.domain.entities.Purchase;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseRepository {
    List<Purchase> findPurchasesByDate(LocalDate date);
}
