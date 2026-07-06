package org.generation.italy.examples.model.tropico;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buildingtype")
public class BuildingType implements Serializable {
    @Id
    private Integer id;

    // nullable = false only enforces NOT NULL. If name should
    // also be unique (no two BuildingType rows with the same name),
    // then unique = true is necessary to express that business rule and
    // to generate the matching DDL.
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "category", length = 20)
    private String category;

    @Column(name = "construction_cost", nullable = false)
    private int constructionCost;

    @Column(name = "maintenance_cost", precision = 10, scale = 2, nullable = false)
    private BigDecimal maintenanceCost;

    @Column(name = "max_workers")
    private Integer maxWorkers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "input_resource_id")
    private Resource inputResource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "output_resource_id")
    private Resource outputResource;

    @Column(name = "production_rate", precision = 5, scale = 2)
    private BigDecimal productionRate;

    @OneToMany(mappedBy = "buildingType", fetch = FetchType.LAZY)
    private List<Building> buildings = new ArrayList<>();

    public BuildingType() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getConstructionCost() {
        return constructionCost;
    }

    public BigDecimal getMaintenanceCost() {
        return maintenanceCost;
    }

    public Integer getMaxWorkers() {
        return maxWorkers;
    }

    public Resource getInputResource() {
        return inputResource;
    }

    public Resource getOutputResource() {
        return outputResource;
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

    public void setConstructionCost(int constructionCost) {
        this.constructionCost = constructionCost;
    }

    public void setMaintenanceCost(BigDecimal maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public void setMaxWorkers(Integer maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public void setInputResource(Resource inputResource) {
        this.inputResource = inputResource;
    }

    public void setOutputResource(Resource outputResource) {
        this.outputResource = outputResource;
    }

    public void setProductionRate(BigDecimal productionRate) {
        this.productionRate = productionRate;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}
