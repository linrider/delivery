package com.delivery.web.client.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SettlementModel {
    @JsonProperty("Ref")
    private String ref;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("DescriptionRu")
    private String descriptionRu;
    @JsonProperty("SettlementTypeDescription")
    private String settlementTypeDescription;
    @JsonProperty("SettlementTypeDescriptionRu")
    private String settlementTypeDescriptionRu;
    @JsonProperty("AreaDescription")
    private String areaDescription;
    @JsonProperty("AreaDescriptionRu")
    private String areaDescriptionRu;
    @JsonProperty("DeliveryDate")
    private DeliveryDate deliveryDate;

    @Data
    public static class DeliveryDate {
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
        private LocalDateTime date;

        @JsonProperty("timezone_type")
        private String timezoneType;

        @JsonProperty("timezone")
        private String timeZone;

    }
}
