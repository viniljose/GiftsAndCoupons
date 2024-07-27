package org.giftsncoupons.promotion.domain.valueobjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingResponse {
    private String confirmationId;
    private String deliveryDate;
    private BigDecimal shippingCost;
}
