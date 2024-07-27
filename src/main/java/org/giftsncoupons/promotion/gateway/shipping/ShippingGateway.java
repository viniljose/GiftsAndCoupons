package org.giftsncoupons.promotion.gateway.shipping;

import org.giftsncoupons.promotion.domain.valueobjects.ShippingRequest;
import org.giftsncoupons.promotion.domain.valueobjects.ShippingResponse;
import org.giftsncoupons.promotion.domain.valueobjects.ShippingStatusResponse;

public interface ShippingGateway {
    ShippingResponse initiateShipping(ShippingRequest request);
    ShippingStatusResponse getShippingStatus(String confirmationId);
}
