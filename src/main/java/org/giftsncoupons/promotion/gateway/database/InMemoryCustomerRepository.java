package org.giftsncoupons.promotion.gateway.database;

import org.giftsncoupons.promotion.domain.entities.Customer;
import org.giftsncoupons.promotion.domain.repositories.CustomerRepository;
import org.giftsncoupons.promotion.domain.valueobjects.Address;
import org.giftsncoupons.promotion.domain.valueobjects.Email;
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

    @Override
    public void loadCustomers() {
        for (int i = 1; i <= 1200; i++) {
            Customer customer = new Customer();
            customer.setId((long) i);
            customer.setName("Customer " + i);
            customer.setEmail(new Email("customer" + i + "@example.com"));
            customer.setAddress(new Address("Street " + i, "City", "State", "12345"));
            customerMap.put((long) i,customer);
        }
    }

    // Method to add customer to the repository for testing purposes
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }
}
