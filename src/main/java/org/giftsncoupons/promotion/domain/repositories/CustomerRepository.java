package org.giftsncoupons.promotion.domain.repositories;

import org.giftsncoupons.promotion.domain.entities.Customer;

import java.time.LocalDate;
import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);
    void loadCustomers();
}