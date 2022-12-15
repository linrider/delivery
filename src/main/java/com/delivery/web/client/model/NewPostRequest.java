package com.delivery.web.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewPostRequest {
    private String modelName;
    private String calledMethod;
    private String apiKey;
    private MethodProperties methodProperties;

    public NewPostRequest(String modelName, String calledMethod, MethodProperties methodProperties) {
        this.modelName = modelName;
        this.calledMethod = calledMethod;
        this.methodProperties = methodProperties;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MethodProperties {
        @JsonProperty("Page")
        private int page;
        @JsonProperty("CitySender")
        private String citySender;
        @JsonProperty("CityRecipient")
        private String cityRecipient;
        @JsonProperty("DateTime")
        private String dateTime;
        @JsonProperty("ServiceType")
        private String serviceType;

        public MethodProperties(int page) {
            this.page = page;
        }

        public MethodProperties(String citySender, String cityRecipient, String dateTime, String serviceType) {
            this.citySender = citySender;
            this.cityRecipient = cityRecipient;
            this.dateTime = dateTime;
            this.serviceType = serviceType;
        }

    }


    public static NewPostRequest getSettlements(int page) {
        return new NewPostRequest("AddressGeneral", "getSettlements", new MethodProperties(page));
    }
    public static NewPostRequest getDocumentDeliveryDate(String citySender, String cityRecipient, String dateTime ) {
        return new NewPostRequest("InternetDocument", "getDocumentDeliveryDate",
                new MethodProperties(citySender, cityRecipient, dateTime, "WarehouseWarehouse"));
    }

}

