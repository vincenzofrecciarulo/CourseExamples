package org.generation.italy.examples.tropico.modelexercise;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Resource")
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name ="base_market_price")
    private BigDecimal baseMarketPrice;

    @Column(name = "is_processed")
    private boolean isProcessed;

    @OneToMany(mappedBy = "inputResource")
    private List<BuildingType> inputBuildingTypes = new ArrayList<>();

    @OneToMany(mappedBy = "outputResource")
    private List<BuildingType> outputBuildingTypes = new ArrayList<>();

    public Resource(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBaseMarketPrice() {
        return baseMarketPrice;
    }

    public void setBaseMarketPrice(BigDecimal baseMarketPrice) {
        this.baseMarketPrice = baseMarketPrice;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    public List<BuildingType> getInputBuildingTypes() {
        return inputBuildingTypes;
    }

    public void setInputBuildingTypes(List<BuildingType> inputBuildingTypes) {
        this.inputBuildingTypes = inputBuildingTypes;
    }

    public List<BuildingType> getOutputBuildingTypes() {
        return outputBuildingTypes;
    }

    public void setOutputBuildingTypes(List<BuildingType> outputBuildingTypes) {
        this.outputBuildingTypes = outputBuildingTypes;
    }
}