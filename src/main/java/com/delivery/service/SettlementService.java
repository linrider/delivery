package com.delivery.service;

import com.delivery.entity.Settlement;
import com.delivery.repository.SettlementRepository;
import com.delivery.service.dto.DeliveryDateDTO;
import com.delivery.service.mapper.DeliveryDateMapper;
import com.delivery.service.mapper.SettlementMapper;
import com.delivery.web.client.NewPostClient;
import com.delivery.web.client.model.SettlementModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SettlementService {
    private final SettlementRepository settlementRepository;
    private final NewPostClient newPostClient;
    private final SettlementMapper settlementMapper;
    private final DeliveryDateMapper deliveryDateMapper;

    @Transactional
    public void refresh() {
        StopWatch stopWatch = StopWatch.createStarted();
        int totalCount = 0;
        int page = 1;
        boolean isLoading = true;
        settlementRepository.truncate();
        log.info("Table is clean");
        while (isLoading) {
            List<Settlement> settlementsList = newPostClient.getSettlementsList(page).stream()
                    .map(settlementMapper::toEntity)
                    .collect(Collectors.toList());
            if (settlementsList.isEmpty()) {
                isLoading = false;
            }
            settlementRepository.saveAll(settlementsList);
            totalCount += settlementsList.size();
            log.info("Save page = {}, count = {}, totalcount = {}, wTime = {}", page, settlementsList.size(), totalCount, stopWatch.getTime());
            page++;
        }
        log.info("Finish refresh {}, wTime = {}", totalCount, stopWatch.getTime());
    }

    public DeliveryDateDTO getDeliveryDate(String citySender, String cityRecipient, LocalDate date) {
        return newPostClient.getDeliveryDate(citySender, cityRecipient, date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))).stream()
                .map(SettlementModel::getDeliveryDate)
                .map(deliveryDateMapper::toDto).findFirst().orElseThrow();
    }

    public List<Settlement> searchCity(String search) {
        return settlementRepository.findAllByDescriptionLikeAndDescriptionRuLikeInLowerCase(search.toLowerCase());
    }
}
