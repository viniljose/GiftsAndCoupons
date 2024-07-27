package org.giftsncoupons.promotion.domain.entities;

import lombok.Data;
import org.giftsncoupons.promotion.domain.valueobjects.Address;
import org.giftsncoupons.promotion.domain.valueobjects.Email;
@Data
public class Customer {
    private Long id;
    private String name;
    private Email email;
    private Address address;
    // getters and setters
}
