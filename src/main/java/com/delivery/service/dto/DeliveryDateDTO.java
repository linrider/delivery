package com.delivery.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryDateDTO {
    private LocalDateTime date;
    private String timezoneType;
    private String timeZone;
}
