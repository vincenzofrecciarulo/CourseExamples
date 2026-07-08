package org.generation.italy.examples.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "production_batch")
public class ProductionBatch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(name = "production_date")
    private LocalDate productionDate;

    @Column
    private Integer amount;

    @Column(name = "market_value", precision =  10, scale = 2)
    private BigDecimal marketValue;

    public  ProductionBatch() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "ProductionBatch{" +
                "id=" + id +
                ", buildingId=" + (building != null ? building.getId() : "null") +
                ", productionDate=" + productionDate +
                ", amount=" + amount +
                ", marketValue=" + marketValue +
                '}';
    }
}
