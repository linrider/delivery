package com.delivery.entity;

import javax.persistence.*;


@Entity
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

    public Settlement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public String getSettlementTypeDescription() {
        return settlementTypeDescription;
    }

    public void setSettlementTypeDescription(String settlementTypeDescription) {
        this.settlementTypeDescription = settlementTypeDescription;
    }

    public String getSettlementTypeDescriptionRu() {
        return settlementTypeDescriptionRu;
    }

    public void setSettlementTypeDescriptionRu(String settlementTypeDescriptionRu) {
        this.settlementTypeDescriptionRu = settlementTypeDescriptionRu;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public String getAreaDescriptionRu() {
        return areaDescriptionRu;
    }

    public void setAreaDescriptionRu(String areaDescriptionRu) {
        this.areaDescriptionRu = areaDescriptionRu;
    }
}
