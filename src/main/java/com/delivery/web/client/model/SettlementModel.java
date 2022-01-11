package com.delivery.web.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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
}
