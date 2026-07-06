package org.generation.italy.examples.model.tropico;

import jakarta.persistence.*;
import org.generation.italy.examples.model.tropico.BuildingType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_type_id")
    private BuildingType buildingType;

    @Column(name = "budget_level")
    private Integer budgetLevel;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "jobBuilding", fetch = FetchType.LAZY)
    private List<Citizen> workers = new ArrayList<>();

    @OneToMany(mappedBy = "homeBuilding", fetch = FetchType.LAZY)
    private List<Citizen> residents = new ArrayList<>();

    @OneToMany(mappedBy = "batchBuilding", fetch = FetchType.LAZY)
    private List<ProductionBatch> productionBatches = new ArrayList<>();

    public Building() {}

    public Integer getId() {
        return id;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public Integer getBudgetLevel() {
        return budgetLevel;
    }

    public Boolean getActive() {
        return isActive;
    }

    public List<Citizen> getWorkers() {
        return workers;
    }

    public List<Citizen> getResidents() {
        return residents;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public void setBudgetLevel(Integer budgetLevel) {
        this.budgetLevel = budgetLevel;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setWorkers(List<Citizen> workers) {
        this.workers = workers;
    }

    public void setResidents(List<Citizen> residents) {
        this.residents = residents;
    }
}
