package com.delivery.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "settlements_np")
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "ref")
    private String ref;

    @Column(name = "description")
    private String description;

    @Column(name = "description_ru")
    private String descriptionRu;

    @Column(name = "settlement_type_description")
    private String settlementTypeDescription;

    @Column(name = "settlement_type_description_ru")
    private String settlementTypeDescriptionRu;

    @Column(name = "area_description")
    private String areaDescription;

    @Column(name = "area_description_ru")
    private String areaDescriptionRu;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
