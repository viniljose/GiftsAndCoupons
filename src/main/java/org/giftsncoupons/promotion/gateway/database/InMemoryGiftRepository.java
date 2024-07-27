package org.giftsncoupons.promotion.gateway.database;

import org.giftsncoupons.promotion.domain.entities.DeliveryStatus;
import org.giftsncoupons.promotion.domain.entities.Gift;
import org.giftsncoupons.promotion.domain.repositories.GiftRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class InMemoryGiftRepository implements GiftRepository {
    private Map<LocalDate, List<Gift>> giftsByDate = new HashMap<>();

    @Override
    public Optional<Gift> findFirstAvailableGiftByDate(LocalDate date) {
        List<Gift> gifts = giftsByDate.get(date);
        if (gifts != null) {
            return gifts.stream().filter(g -> g.getDeliveryStatus() == DeliveryStatus.AVAILABLE).findFirst();
        }
        return Optional.empty();
    }

    @Override
    public void save(Gift gift) {
        giftsByDate
                .computeIfAbsent(gift.getAllocatedDate(), k -> new ArrayList<>())
                .add(gift);
    }
}
