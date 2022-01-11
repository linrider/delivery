package com.delivery.repository;

import com.delivery.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SettlementRepository extends CrudRepository<Settlement, Long> {
    public Settlement getByRef(String ref);

}
