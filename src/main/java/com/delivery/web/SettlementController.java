package com.delivery.web;

import com.delivery.config.ApplicationProperties;
import com.delivery.entity.Settlement;
import com.delivery.service.SettlementService;
import com.delivery.web.client.NewPostClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/settlements")
@RequiredArgsConstructor
public class SettlementController {
    private final SettlementService settlementService;
    //TODO добавить получение списка городов постранично, добавить API для поиска города по названию
    @GetMapping("/refresh")
    public String refreshSettlements() {
        settlementService.refresh();
        return "DB has refreshed.";
    }

    @GetMapping()
    public String getDeliveryDate(@RequestParam String citySender, @RequestParam String cityRecipient, @RequestParam LocalDate date) {
        return settlementService.getDeliveryDate(citySender, cityRecipient, date);
    }

    @GetMapping("/search")
    public List<Settlement> searchCity(@RequestParam String search) {
        return settlementService.searchCity(search);
    }
}
