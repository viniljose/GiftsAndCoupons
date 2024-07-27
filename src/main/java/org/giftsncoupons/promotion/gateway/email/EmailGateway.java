package org.giftsncoupons.promotion.gateway.email;

import org.giftsncoupons.promotion.domain.entities.Customer;
import org.giftsncoupons.promotion.domain.entities.Gift;

public interface EmailGateway {
    void sendGiftAllocationEmail(Customer customer, Gift gift);
}
