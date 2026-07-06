package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Resource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column
    private BigDecimal baseMarketPrice;

    @Column
    private boolean isProcessed;

    @OneToMany
    @JoinColumn(name = "inputResourceId")
    private List<BuildingType> input = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "outputResourceId")
    private List<BuildingType> output = new ArrayList<>();

    public Resource(){}

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getBaseMarketPrice() {
        return baseMarketPrice;
    }
    public boolean isProcessed() {
        return isProcessed;
    }
    public List<BuildingType> getInput() {
        return input;
    }
    public List<BuildingType> getOutput() {
        return output;
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
    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
    public void setInput(List<BuildingType> input) {
        this.input = input;
    }
    public void setOutput(List<BuildingType> output) {
        this.output = output;
    }
}
