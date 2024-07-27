package org.giftsncoupons.promotion.gateway.database;

import org.giftsncoupons.promotion.domain.entities.Customer;
import org.giftsncoupons.promotion.domain.entities.Purchase;
import org.giftsncoupons.promotion.domain.entities.PurchaseItem;
import org.giftsncoupons.promotion.domain.repositories.PurchaseRepository;
import org.giftsncoupons.promotion.domain.valueobjects.Address;
import org.giftsncoupons.promotion.domain.valueobjects.Email;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    @Override
    public void loadPurchases(LocalDate date) {
        for (int i = 1; i <= 1200; i++) {
            Purchase purchase = new Purchase();
            purchase.setId((long) i);
            //TODO change the approach to load customers.
            Customer customer = new Customer();
            customer.setId((long) i);
            customer.setName("Customer " + i);
            customer.setEmail(new Email("customer" + i + "@example.com"));
            customer.setAddress(new Address("Street " + i, "City", "State", "12345"));
            purchase.setCustomer(customer);
            purchase.setDate(LocalDate.now());
            purchase.addItem(new PurchaseItem((long) i, "Item" + i, new BigDecimal("2000"), 1, purchase));
            purchases.add(purchase);
        }
    }

    // Method to add purchase to the repository for testing purposes
    public void save(Purchase purchase) {
        purchases.add(purchase);
    }
}
