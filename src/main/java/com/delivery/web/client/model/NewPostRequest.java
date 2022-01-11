package com.delivery.web.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewPostRequest {
    private String modelName;
    private String calledMethod;
    private String apiKey;
    private MethodProperties methodProperties;

    @Data
    @AllArgsConstructor
    public static class MethodProperties {
        @JsonProperty("Page")
        private int page;
}
}

