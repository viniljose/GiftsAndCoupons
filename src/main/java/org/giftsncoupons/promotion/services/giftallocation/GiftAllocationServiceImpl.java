package org.giftsncoupons.promotion.services.giftallocation;

import org.giftsncoupons.promotion.domain.entities.DeliveryStatus;
import org.giftsncoupons.promotion.domain.entities.Gift;
import org.giftsncoupons.promotion.domain.entities.Purchase;
import org.giftsncoupons.promotion.domain.repositories.CustomerRepository;
import org.giftsncoupons.promotion.domain.repositories.GiftRepository;
import org.giftsncoupons.promotion.domain.repositories.PurchaseRepository;
import org.giftsncoupons.promotion.domain.valueobjects.ShippingRequest;
import org.giftsncoupons.promotion.domain.valueobjects.ShippingResponse;
import org.giftsncoupons.promotion.gateway.email.EmailGateway;
import org.giftsncoupons.promotion.gateway.shipping.ShippingGateway;
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
    private CustomerRepository customerRepository;
    @Autowired
    private EmailGateway emailGateway;
    @Autowired
    private ShippingGateway shippingGateway;

    public void allocateGiftsForPurchases(LocalDate date) {
        List<Purchase> purchases = purchaseRepository.findPurchasesByDate(date);
        System.out.println("purchases------->"+purchases.size());
        int allocatedCount = 0;
        for (Purchase purchase : purchases) {
            if (allocatedCount >= 1000) {
                break;
            }
            if (purchase.getAmount().compareTo(new BigDecimal("1999")) >= 0) {
                Optional<Gift> giftOpt = giftRepository.findFirstAvailableGiftByDate(date);
                if (giftOpt.isPresent()) {
                    Gift gift = giftOpt.get();
                    gift.setAllocatedDate(date);
                    gift.setDeliveryStatus(DeliveryStatus.ALLOCATED);
                    giftRepository.save(gift);

                    // Initiate shipping
                    ShippingRequest shippingRequest = new ShippingRequest(
                            purchase.getCustomer().getName(),
                            purchase.getCustomer().getAddress().toString(),
                            purchase.getCustomer().getAddress().getPostalCode(),
                            purchase.getCustomer().getEmail().getEmailAddress(),
                            gift.getItemCode(),
                            "Warehouse Location"
                    );
                    ShippingResponse shippingResponse = shippingGateway.initiateShipping(shippingRequest);

                    // Update gift with shipping details
                    gift.setShippingConfirmationId(shippingResponse.getConfirmationId());
                    gift.setDeliveryDate(LocalDate.parse(shippingResponse.getDeliveryDate()));
                    giftRepository.save(gift);

                    // Send email notification
                    emailGateway.sendGiftAllocationEmail(purchase.getCustomer(), gift);
                    allocatedCount++;
                }
            }
        }
    }

    @Override
    public long availableGifts(LocalDate date) {
        return giftRepository.availableGifts(date);
    }

    @Override
    public long allocatedGifts(LocalDate date) {
        return giftRepository.allocatedGifts(date);
    }

    @Override
    public void init(LocalDate date) {
        customerRepository.loadCustomers();
        purchaseRepository.loadPurchases(date);
        giftRepository.loadGifts(date);
    }
}
