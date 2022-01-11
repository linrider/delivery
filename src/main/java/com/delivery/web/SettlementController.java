package com.delivery.web;

import com.delivery.config.ApplicationProperties;
import com.delivery.service.SettlementService;
import com.delivery.web.client.NewPostClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/settlements")
@RequiredArgsConstructor
public class SettlementController {
    private final SettlementService settlementService;
    //TODO добавить получение списка городов постранично, добавить API для поиска города по названию
    @GetMapping("/refresh")
    public String refreshSettlements() {
        settlementService.refresh();
        return "List of settlements was refreshed.";
    }

//    @GetMapping("/cities")
//    public String showCities() throws JsonProcessingException {
//        return newPostClient.getSettlementsList(1).toString();
//    }
}
