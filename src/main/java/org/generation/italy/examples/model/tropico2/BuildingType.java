package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "buildingtype")
public class BuildingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public BuildingType(){

    }
}
