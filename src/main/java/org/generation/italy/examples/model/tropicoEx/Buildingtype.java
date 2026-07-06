package org.generation.italy.examples.model.tropicoEx;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Table(name = "buildingtype")
public class Buildingtype implements Serializable {
    @Id
    @Column(nullable = false)
    private int id;

    @Column(name="name",length = 50,unique = true,nullable = false)
    private String name;

    @Column(name="category",length = 20)
    @Enumerated(EnumType.STRING)
    private Categories category;

    @Column(name="construction_cost",nullable = false)
    private int cost;

    @Column(name="maintenance_cost",nullable = false,precision = 10,scale = 2)
    private BigDecimal maintenanceCost;

    @Column(name="max_workers")
    private int maxWorkers=0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "input_resource_id")
    private Resource inputResource;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "output_resource_id")
    private Resource outputResource;

    @Column(name="production_rate",precision = 5,scale = 2)
    private BigDecimal productionRate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "buildingtype")
    private java.util.List<Building> buildings=new ArrayList<>();

    public Buildingtype() {
    }
}
