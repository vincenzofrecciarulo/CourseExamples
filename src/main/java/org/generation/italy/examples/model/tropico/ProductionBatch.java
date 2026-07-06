package org.generation.italy.examples.model.tropico;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "production_batch")
public class ProductionBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building batchBuilding;

    @Column(name = "production_date")
    private LocalDate productionDate;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "market_value", precision = 10, scale = 2)
    private BigInteger marketValue;

    public ProductionBatch() {}

    public Integer getId() {
        return id;
    }

    public Building getBatchBuilding() {
        return batchBuilding;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public BigInteger getMarketValue() {
        return marketValue;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBatchBuilding(Building batchBuilding) {
        this.batchBuilding = batchBuilding;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setMarketValue(BigInteger marketValue) {
        this.marketValue = marketValue;
    }
}
