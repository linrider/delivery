package com.delivery.web.client;

import com.delivery.config.ApplicationProperties;
import com.delivery.web.client.model.NewPostRequest;
import com.delivery.web.client.model.NewPostResponse;
import com.delivery.web.client.model.SettlementModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewPostClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ApplicationProperties applicationProperties;

    private NewPostResponse sendPost(int pageNumber) {
        String url = applicationProperties.getNewPostApiProperties().getUrl() + "/getSettlements";
        NewPostRequest newPostRequest = new NewPostRequest("AddressGeneral", "getSettlements",
                applicationProperties.getNewPostApiProperties().getApiKey(), new NewPostRequest.MethodProperties(pageNumber));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<NewPostResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, new HttpEntity<>(newPostRequest, httpHeaders), NewPostResponse.class);
        return response.getBody();
    }

    public List<SettlementModel> getSettlementsList(int page) {

        NewPostResponse response = sendPost(page);
        if (!response.isSuccess()) {
            throw new IllegalArgumentException("" + response.getErrors());
        }
        return response.getData();
    }
}
