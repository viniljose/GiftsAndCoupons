package org.giftsncoupons.promotion.services.giftallocation;

import org.giftsncoupons.promotion.domain.entities.DeliveryStatus;
import org.giftsncoupons.promotion.domain.entities.Gift;
import org.giftsncoupons.promotion.domain.entities.Purchase;
import org.giftsncoupons.promotion.domain.repositories.GiftRepository;
import org.giftsncoupons.promotion.domain.repositories.PurchaseRepository;
import org.giftsncoupons.promotion.services.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GiftAllocationServiceImpl implements GiftAllocationService{
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private GiftRepository giftRepository;
    @Autowired
    private EmailService emailService;

/*    public GiftAllocationService(PurchaseRepository purchaseRepository, GiftRepository giftRepository, EmailService emailService) {
        this.purchaseRepository = purchaseRepository;
        this.giftRepository = giftRepository;
        this.emailService = emailService;
    }*/

    public void allocateGiftsForPurchases(LocalDate date) {
        List<Purchase> purchases = purchaseRepository.findPurchasesByDate(date);
        for (Purchase purchase : purchases) {
            if (purchase.getAmount().compareTo(new BigDecimal("1999")) >= 0) {
                Optional<Gift> giftOpt = giftRepository.findFirstAvailableGiftByDate(date);
                if (giftOpt.isPresent()) {
                    Gift gift = giftOpt.get();
                    gift.setAllocatedDate(date);
                    gift.setDeliveryStatus(DeliveryStatus.ALLOCATED);
                    giftRepository.save(gift);

                    // Send email notification
                    emailService.sendGiftAllocationEmail(purchase.getCustomer(), gift);
                }
            }
        }
    }
}
