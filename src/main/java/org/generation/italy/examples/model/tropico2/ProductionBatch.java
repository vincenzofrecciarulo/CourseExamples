package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class ProductionBatch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Integer buildingId;

    @Column
    private LocalDate date;

    @Column
    private Integer amount;

    @Column
    private BigDecimal marketValue;

    public ProductionBatch() {
    }

    public Integer getId() {
        return id;
    }
    public Integer getBuildingId() {
        return buildingId;
    }
    public LocalDate getDate() {
        return date;
    }
    public Integer getAmount() {
        return amount;
    }
    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }
}
