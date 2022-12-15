package com.delivery.service.mapper;

import com.delivery.service.dto.DeliveryDateDTO;
import com.delivery.web.client.model.SettlementModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryDateMapper {
    DeliveryDateDTO toDto(SettlementModel.DeliveryDate model);

}
