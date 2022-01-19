package com.delivery.service;

import com.delivery.entity.Settlement;
import com.delivery.repository.SettlementRepository;
import com.delivery.service.mapper.SettlementMapper;
import com.delivery.web.client.NewPostClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SettlementService {
    @Autowired
    private final SettlementRepository settlementRepository;
    private final NewPostClient newPostClient;
    private final SettlementMapper settlementMapper;

    public void refresh() {
        int page = 1;
        boolean isLoading = true;
        while (isLoading) {
            List<Settlement> settlementsList = newPostClient.getSettlementsList(page).stream()
                    .map(settlementMapper::toEntity)
                    .collect(Collectors.toList());
            if (settlementsList.isEmpty()) {
                isLoading = false;
            }
            settlementsList.forEach(settlement -> {
                Settlement settlementFromDB = settlementRepository.getByRef(settlement.getRef());
                if (!settlement.equals(settlementFromDB)) {
                    settlementRepository.save(settlement);
                }
            });
            page++;
        }
    }
}
