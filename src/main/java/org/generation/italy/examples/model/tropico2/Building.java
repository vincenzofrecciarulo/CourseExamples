package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_type_id")
    private BuildingType buildingType;

    @Column(name = "budget_level")
    private Integer budgetLeve;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "jobBuilding", fetch = FetchType.LAZY)
    private List<Citizen> workers = new ArrayList<>();


    public Building(){

    }

}
