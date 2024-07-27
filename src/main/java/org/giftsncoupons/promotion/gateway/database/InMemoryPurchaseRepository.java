package org.giftsncoupons.promotion.gateway.database;

import org.giftsncoupons.promotion.domain.entities.Purchase;
import org.giftsncoupons.promotion.domain.repositories.PurchaseRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryPurchaseRepository implements PurchaseRepository {
    private List<Purchase> purchases = new ArrayList<>();

    @Override
    public List<Purchase> findPurchasesByDate(LocalDate date) {
        return purchases.stream()
                .filter(p -> p.getDate().isEqual(date))
                .collect(Collectors.toList());
    }

    // Method to add purchase to the repository for testing purposes
    public void save(Purchase purchase) {
        purchases.add(purchase);
    }
}
