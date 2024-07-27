package org.giftsncoupons.promotion.services.email;

import org.giftsncoupons.promotion.domain.entities.Customer;
import org.giftsncoupons.promotion.domain.entities.Gift;

public interface EmailService {
    void sendGiftAllocationEmail(Customer customer, Gift gift);
}
