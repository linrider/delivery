package com.delivery.repository;

import com.delivery.entity.Settlement;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SettlementRepository extends CrudRepository<Settlement, Long> {
    @Modifying
    @Query(value = "truncate table settlements_np", nativeQuery = true)
    void truncate();

    @Query(value = "select * from settlements_np c where lower(description) like :name or lower(description_ru) like :name", nativeQuery = true)
    public List<Settlement> findAllByDescriptionLikeAndDescriptionRuLikeInLowerCase(@Param("name") String settlementName);

}
