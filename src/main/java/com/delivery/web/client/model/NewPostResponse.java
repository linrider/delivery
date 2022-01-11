package com.delivery.web.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewPostResponse {
    private boolean success;
    private List<SettlementModel> data;
    private List<String> errors;
}
