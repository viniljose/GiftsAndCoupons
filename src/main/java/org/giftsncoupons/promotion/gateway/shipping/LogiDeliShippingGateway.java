package org.giftsncoupons.promotion.gateway.shipping;
import org.giftsncoupons.promotion.domain.valueobjects.ShippingRequest;
import org.giftsncoupons.promotion.domain.valueobjects.ShippingResponse;
import org.giftsncoupons.promotion.domain.valueobjects.ShippingStatusResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class LogiDeliShippingGateway implements ShippingGateway {
    @Value("${logideli.api.base-url}")
    private String logiDeliBaseUrl;

    private  RestTemplate restTemplate;

    public LogiDeliShippingGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ShippingResponse initiateShipping(ShippingRequest request) {
        String url = UriComponentsBuilder.fromHttpUrl(logiDeliBaseUrl)
                .path("/shipping/initiate")
                .toUriString();

        return restTemplate.postForObject(url, request, ShippingResponse.class);
    }

    public ShippingStatusResponse getShippingStatus(String confirmationId) {
        String url = UriComponentsBuilder.fromHttpUrl(logiDeliBaseUrl)
                .path("/shipping/status")
                .queryParam("confirmationId", confirmationId)
                .toUriString();

        return restTemplate.getForObject(url, ShippingStatusResponse.class);
    }
}
