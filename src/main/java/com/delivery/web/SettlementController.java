package com.delivery.web;

import com.delivery.entity.Settlement;
import com.delivery.service.SettlementService;
import com.delivery.service.dto.DeliveryDateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SettlementController {
    private final SettlementService settlementService;
    //TODO добавить получение списка городов постранично, добавить API для поиска города по названию
    @GetMapping("/refresh")
    public String refreshSettlements() {
        settlementService.refresh();
        return "DB has refreshed.";
    }

    @GetMapping("/getdate")
    public DeliveryDateDTO getDeliveryDate(@RequestParam String citySender, @RequestParam String cityRecipient,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return settlementService.getDeliveryDate(citySender, cityRecipient, date);
    }

    @GetMapping("/search")
    public List<Settlement> searchCity(@RequestParam String search) {
        return settlementService.searchCity(search);
    }
}
