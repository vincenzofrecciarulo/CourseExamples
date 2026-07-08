package org.generation.italy.examples.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "resource")
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(name = "base_market_price", precision = 10, scale = 2)
    private BigDecimal baseMarketPrice;

    @OneToMany(mappedBy = "outputResource", fetch = FetchType.LAZY)
    private List<BuildingType> outputFor = new ArrayList<>();

    @OneToMany(mappedBy = "inputResource", fetch = FetchType.LAZY)
    private List<BuildingType> inputFor = new ArrayList<>();

    public Resource() {}

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

    public List<BuildingType> getOutputFor() {
        return outputFor;
    }

    public void setOutputFor(List<BuildingType> outputFor) {
        this.outputFor = outputFor;
    }

    public List<BuildingType> getInputFor() {
        return inputFor;
    }

    public void setInputFor(List<BuildingType> inputFor) {
        this.inputFor = inputFor;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseMarketPrice=" + baseMarketPrice +
                ", outputForCount=" + (outputFor != null ? outputFor.size() : 0) +
                ", inputForCount=" + (inputFor != null ? inputFor.size() : 0) +
                '}';
    }
}
