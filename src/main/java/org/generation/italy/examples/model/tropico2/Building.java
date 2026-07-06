package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;
import org.generation.italy.examples.model.tropico.BuildingType;
import org.generation.italy.examples.model.tropico.Citizen;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment -> serial
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_type_id")
    private BuildingType buildingType;

    @Column
    private Integer budgetLevel;

    @Column
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobBuilding")
    private List<Citizen> jobBuilding = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "homeBuildingId")
    private List<Citizen> residents = new ArrayList<>();

    public Building(){}

    public int getId() {
        return id;
    }
    public BuildingType getBuildingType() {
        return buildingType;
    }
    public int getBudgetLevel() {
        return budgetLevel;
    }
    public boolean isActive() {
        return isActive;
    }
    public List<Citizen> getWorkers() {
        return jobBuilding;
    }
    public List<Citizen> getHomeBuilding(){ return residents; }

    public void setId(int id) {
        this.id = id;
    }
    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }
    public void setBudgetLevel(int budgetLevel) {
        this.budgetLevel = budgetLevel;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    public void setWorkers(List<Citizen> jobBuilding) {
        this.jobBuilding = jobBuilding;
    }
    public void setHomeBuilding(List<Citizen> residents) { this.residents = residents; }
}
