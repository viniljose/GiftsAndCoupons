package org.giftsncoupons.promotion.gateway.email;

import org.giftsncoupons.promotion.domain.entities.Customer;
import org.giftsncoupons.promotion.domain.entities.Gift;
import org.springframework.stereotype.Service;

@Service
public class EmailGatewayImpl implements EmailGateway {
    @Override
    public void sendGiftAllocationEmail(Customer customer, Gift gift) {
        // Implementation to send email
    }
}
