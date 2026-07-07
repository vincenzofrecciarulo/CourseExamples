package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Building")
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

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<ProductionBatch> productionBatches = new ArrayList<>();

    public Building() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public org.generation.italy.examples.model.tropico2.BuildingType getBuildingType() { return buildingType; }
    public void setBuildingType(org.generation.italy.examples.model.tropico2.BuildingType buildingType) { this.buildingType = buildingType; }
    public Integer getBudgetLevel() { return budgetLevel; }
    public void setBudgetLevel(Integer budgetLevel) { this.budgetLevel = budgetLevel; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean active) { isActive = active; }
    public List<Citizen> getWorkers() { return workers; }
    public void setWorkers(List<Citizen> workers) { this.workers = workers; }
    public List<Citizen> getResidents() { return residents; }
    public void setResidents(List<Citizen> residents) { this.residents = residents; }
    public List<ProductionBatch> getProductionBatches() { return productionBatches; }
    public void setProductionBatches(List<ProductionBatch> productionBatches) { this.productionBatches = productionBatches; }

}