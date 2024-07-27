package org.giftsncoupons.promotion.services.giftallocation;

import java.time.LocalDate;

public interface GiftAllocationService {
    void allocateGiftsForPurchases(LocalDate date);
    long availableGifts(LocalDate date);
    long allocatedGifts(LocalDate date);
    void init(LocalDate date);
}
