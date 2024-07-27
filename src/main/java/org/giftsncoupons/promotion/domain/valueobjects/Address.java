package org.giftsncoupons.promotion.domain.valueobjects;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    // getters and setters
}
