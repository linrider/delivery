package com.delivery.service.mapper;

import com.delivery.entity.Settlement;
import com.delivery.web.client.model.SettlementModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SettlementMapper {
    Settlement toEntity(SettlementModel model);

    @IterableMapping(elementTargetType = Settlement.class)
    List<Settlement> toEntity(List<SettlementModel> model);
}
