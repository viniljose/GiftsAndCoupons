package org.giftsncoupons.promotion.gateway.database;

import org.giftsncoupons.promotion.domain.entities.Customer;
import org.giftsncoupons.promotion.domain.repositories.CustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    private Map<Long, Customer> customerMap = new HashMap<>();

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customerMap.get(id));
    }

    // Method to add customer to the repository for testing purposes
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }
}
