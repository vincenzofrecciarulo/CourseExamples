package org.generation.italy.examples.tropico.modelexercise;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BuildingType")
public class BuildingType implements Serializable{
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "construction_cost")
    private Integer constructionCost;

    @Column(name = "maintenance_cost")
    private BigDecimal maintenanceCost;

    @Column(name = "max_workers")
    private Integer maxWorkers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "input_resource_id")
    private Resource inputResource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "output_resource_id")
    private Resource outputResource;

    @Column(name = "production_rate")
    private BigDecimal productionRate;

    @OneToMany(mappedBy = "buildingType", fetch = FetchType.LAZY)
    private List<Building> buildings = new ArrayList<>();

    public BuildingType () {}

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getConstructionCost() {
        return constructionCost;
    }

    public void setConstructionCost(Integer constructionCost) {
        this.constructionCost = constructionCost;
    }

    public BigDecimal getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(BigDecimal maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public Integer getMaxWorkers() {
        return maxWorkers;
    }

    public void setMaxWorkers(Integer maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public Resource getInputResource() {
        return inputResource;
    }

    public void setInputResource(Resource inputResource) {
        this.inputResource = inputResource;
    }

    public Resource getOutputResource() {
        return outputResource;
    }

    public void setOutputResource(Resource outputResource) {
        this.outputResource = outputResource;
    }

    public BigDecimal getProductionRate() {
        return productionRate;
    }

    public void setProductionRate(BigDecimal productionRate) {
        this.productionRate = productionRate;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}
