package org.generation.italy.examples.model.tropicoEx;

import jakarta.persistence.*;
import org.generation.italy.examples.model.tropico.Building;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Production_Batch")
public class ProductionBatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(name = "production_date")
    private LocalDate productionDate;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "market_value")
    private BigDecimal marketValue;

    public ProductionBatch() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Building getBuilding() {
        return building;
    }
    public void setBuilding(Building building) {
        this.building = building;
    }
    public LocalDate getProductionDate() {
        return productionDate;
    }
    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public BigDecimal getMarketValue() {
        return marketValue;
    }
    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }
}
