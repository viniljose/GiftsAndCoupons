package org.giftsncoupons.promotion.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingStatusResponse {
    private String status;
    private String deliveryDate;
}
