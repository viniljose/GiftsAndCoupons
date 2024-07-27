package org.giftsncoupons.promotion.domain.valueobjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingRequest {
    private String name;
    private String address;
    private String postalCode;
    private String email;
    private String itemCode;
    private String pickupLocation;
}
