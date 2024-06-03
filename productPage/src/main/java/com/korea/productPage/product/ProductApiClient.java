package com.korea.productPage.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProductApiClient {
    private final RestTemplate restTemplate;

    private final String CLIENT_ID = "am5M87xAyX4OADf0qDis";
    private final String CLIENT_SECRET = "jDi3rYZyGC";

    private final String OpenNaverShopUrl_getProduct = "https://openapi.naver.com/v1/search/shop?query={keyword}";

    public ProductResponseDto requestProduct(String keyword){
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(OpenNaverShopUrl_getProduct, HttpMethod.GET, entity, ProductResponseDto.class, keyword).getBody();
    }
}
