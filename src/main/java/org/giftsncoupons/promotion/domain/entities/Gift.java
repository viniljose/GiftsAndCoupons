package org.giftsncoupons.promotion.domain.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class Gift {
    private Long id;
    private String itemCode;
    private String description;
    private BigDecimal value;
    private LocalDate allocatedDate;
    private DeliveryStatus deliveryStatus;
    private String shippingConfirmationId;
    private LocalDate deliveryDate;
}
