package org.generation.italy.examples.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Resource")
public class Resource implements Serializable {
    @Id
    private Integer id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "base_market_price")
    private BigDecimal baseMarketPrice;

    @Column(name = "is_processed")
    private Boolean isProcessed;

    @OneToMany(mappedBy = "inputResource", fetch = FetchType.LAZY)
    private List<BuildingType> inputFor = new ArrayList<>();

    @OneToMany(mappedBy = "outputResource", fetch = FetchType.LAZY)
    private List<BuildingType> outputFor = new ArrayList<>();

    public Resource() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getBaseMarketPrice() { return baseMarketPrice; }
    public void setBaseMarketPrice(BigDecimal baseMarketPrice) { this.baseMarketPrice = baseMarketPrice; }
    public Boolean getIsProcessed() { return isProcessed; }
    public void setIsProcessed(Boolean processed) { isProcessed = processed; }
    public List<BuildingType> getInputFor() { return inputFor; }
    public void setInputFor(List<BuildingType> inputFor) { this.inputFor = inputFor; }
    public List<BuildingType> getOutputFor() { return outputFor; }
    public void setOutputFor(List<BuildingType> outputFor) { this.outputFor = outputFor; }
}
