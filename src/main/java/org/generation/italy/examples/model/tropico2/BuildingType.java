package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class BuildingType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 20)
    private String category;

    @Column
    private Integer constructionCost;

    @Column
    private BigDecimal maxWorker;

    @ManyToOne
    @JoinColumn(name = "input_resource_id")
    private Integer inputResourceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "output_resource_id")
    private Integer outputResourceId;

    @Column
    private BigDecimal productionRate;

    @OneToMany(mappedBy = "buildingType")
    private List<Building> buildings = new ArrayList<>();

    public BuildingType() {
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public Integer getConstructionCost() {
        return constructionCost;
    }
    public BigDecimal getMaxWorker() {
        return maxWorker;
    }
    public Integer getInputResourceId() {
        return inputResourceId;
    }
    public Integer getOutputResourceId() {
        return outputResourceId;
    }
    public BigDecimal getProductionRate() {
        return productionRate;
    }
    public List<Building> getBuildings() {
        return buildings;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setConstructionCost(Integer constructionCost) {
        this.constructionCost = constructionCost;
    }
    public void setMaxWorker(BigDecimal maxWorker) {
        this.maxWorker = maxWorker;
    }
    public void setInputResourceId(Integer inputResourceId) {
        this.inputResourceId = inputResourceId;
    }
    public void setOutputResourceId(Integer outputResourceId) {
        this.outputResourceId = outputResourceId;
    }
    public void setProductionRate(BigDecimal productionRate) {
        this.productionRate = productionRate;
    }
    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}
