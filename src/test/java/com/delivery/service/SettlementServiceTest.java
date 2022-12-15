package com.delivery.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class SettlementServiceTest {

    @Test
    void getDeliveryDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "-" + now.getClass());

    }

    @Test
    void searchCity() {
    }
}