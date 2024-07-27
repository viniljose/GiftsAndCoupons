package org.giftsncoupons.promotion.services.email;

import org.giftsncoupons.promotion.domain.entities.Customer;
import org.giftsncoupons.promotion.domain.entities.Gift;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendGiftAllocationEmail(Customer customer, Gift gift) {
        // Implementation to send email
    }
}
