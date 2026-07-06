package org.generation.italy.examples.model.tropico;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "base_market_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal baseMarketPrice;

    @Column(name = "is_processed")
    private Boolean isProcessed;

    @OneToMany(mappedBy = "inputResource", fetch = FetchType.LAZY)
    private List<BuildingType> inputFor = new ArrayList<>();

    @OneToMany(mappedBy = "outputResource", fetch = FetchType.LAZY)
    private List<BuildingType> outputFor = new ArrayList<>();

    public Resource() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBaseMarketPrice() {
        return baseMarketPrice;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public List<BuildingType> getInputFor() {
        return inputFor;
    }

    public List<BuildingType> getOutputFor() {
        return outputFor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseMarketPrice(BigDecimal baseMarketPrice) {
        this.baseMarketPrice = baseMarketPrice;
    }

    public void setProcessed(Boolean processed) {
        isProcessed = processed;
    }

    public void setInputFor(List<BuildingType> inputFor) {
        this.inputFor = inputFor;
    }

    public void setOutputFor(List<BuildingType> outputFor) {
        this.outputFor = outputFor;
    }
}
