package org.giftsncoupons.promotion.gateway.database;

import org.giftsncoupons.promotion.domain.entities.DeliveryStatus;
import org.giftsncoupons.promotion.domain.entities.Gift;
import org.giftsncoupons.promotion.domain.repositories.GiftRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    @Override
    public long availableGifts(LocalDate date) {
        List<Gift> gifts = giftsByDate.get(date);
        if (gifts != null) {
            return gifts.stream().filter(g -> g.getDeliveryStatus() == DeliveryStatus.AVAILABLE).count();
        }
        return 0;
    }

    @Override
    public long allocatedGifts(LocalDate date) {
        List<Gift> gifts = giftsByDate.get(date);
        if (gifts != null) {
            return gifts.stream().filter(g -> g.getDeliveryStatus() == DeliveryStatus.ALLOCATED).count();
        }
        return 0;
    }

    @Override
    public void loadGifts(LocalDate date) {
        List<Gift> gifts = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            Gift gift = new Gift();
            gift.setId((long) i);
            gift.setItemCode("Gift" + i);
            gift.setDescription("Gift Description " + i);
            gift.setValue(new BigDecimal("500"));
            gift.setAllocatedDate(date);
            gift.setDeliveryStatus(DeliveryStatus.AVAILABLE);
            gifts.add(gift);
        }
        giftsByDate.put(date,gifts);
    }

}
