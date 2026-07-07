package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;
import org.generation.italy.examples.model.tropico.BuildingType;
import org.generation.italy.examples.model.tropico.Citizen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Building")
public class Building2 implements Serializable{


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_type_id")
    private BuildingType2 buildingType2;

    @Column(name= "budget_level")
    private Integer budgetLevel;

    @Column(name= "is_active")
    private boolean isActive;


    @OneToMany(mappedBy = "job building", fetch = FetchType.LAZY)
    private List<Citizen2> workers = new ArrayList<>();

    @OneToMany(mappedBy = "home building", fetch = =FetchType.LAZY)
    private List<Citizen2> residents = new ArrayList<>();

    public Building2() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public BuildingType getBuildingType() { return buildingType2; }
    public void setBuildingType(BuildingType buildingType) { this.buildingType2 = buildingType; }
    public Integer getBudgetLevel() { return budgetLevel; }
    public void setBudgetLevel(Integer budgetLevel) { this.budgetLevel = budgetLevel; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean active) { isActive = active; }
    public List<Citizen> getWorkers() { return workers; }
    public void setWorkers(List<Citizen> workers) { this.workers = workers; }
    public List<Citizen> getResidents() { return residents; }
    public void setResidents(List<Citizen> residents) { this.residents = residents; }
}



