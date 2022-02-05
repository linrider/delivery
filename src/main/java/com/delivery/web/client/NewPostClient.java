package com.delivery.web.client;

import com.delivery.config.ApplicationProperties;
import com.delivery.web.client.model.NewPostRequest;
import com.delivery.web.client.model.NewPostResponse;
import com.delivery.web.client.model.SettlementModel;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class NewPostClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String apiKey;

    public NewPostClient(RestTemplate restTemplate, ApplicationProperties applicationProperties) {
        this.restTemplate = restTemplate;
        this.baseUrl = applicationProperties.getNewPostApiProperties().getUrl();
        this.apiKey = applicationProperties.getNewPostApiProperties().getApiKey();
    }

//    private final ApplicationProperties applicationProperties;

    private NewPostResponse sendPost(NewPostRequest newPostRequest) {
        String url = UriComponentsBuilder.fromUriString(baseUrl).path(newPostRequest.getCalledMethod()).toUriString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<NewPostResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, new HttpEntity<>(newPostRequest, httpHeaders), NewPostResponse.class);
        return response.getBody();
    }

    public List<SettlementModel> getSettlementsList(int page) {
        NewPostRequest newPostRequest = NewPostRequest.getSettlements(page);
        NewPostResponse response = sendPost(newPostRequest);
        if (!response.isSuccess()) {
            throw new IllegalArgumentException("" + response.getErrors());
        }
        return response.getData();
    }

    public String getDeliveryDate(String citySender, String cityRecipient, String dateTime) {
        NewPostRequest newPostRequest = NewPostRequest.getDocumentDeliveryDate(citySender, cityRecipient, dateTime);
        return sendPost(newPostRequest).toString();
    }
}
