package org.giftsncoupons.promotion.services.giftallocation;

import java.time.LocalDate;

public interface GiftAllocationService {
    void allocateGiftsForPurchases(LocalDate date);
}
