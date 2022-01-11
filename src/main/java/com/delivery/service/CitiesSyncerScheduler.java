package com.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitiesSyncerScheduler {
    private final SettlementService settlementService;

    @Scheduled(cron = "0 0 6 * * ?")
    public void sync() {
        settlementService.refresh();
    }

}
