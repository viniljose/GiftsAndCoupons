package org.giftsncoupons.promotion.domain.repositories;

import org.giftsncoupons.promotion.domain.entities.Gift;

import java.time.LocalDate;
import java.util.Optional;

public interface GiftRepository {
    Optional<Gift> findFirstAvailableGiftByDate(LocalDate date);
    void save(Gift gift);
}
