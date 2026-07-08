package org.generation.italy.examples.tropicoexercise;

import jakarta.persistence.*;

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

    // qua dobbiamo prendere l'altro lato della relazione tra le nostre classi
    // che sarà l'opposto presente sull'altra classe e sarà mappato sull'attributo presente in essa
    @OneToMany(mappedBy = "jobBuilding",fetch =  FetchType.LAZY)
    private List<Citizen> workers = new ArrayList<>();

    @OneToMany(mappedBy = "homeBuilding", fetch =  FetchType.LAZY)
    private List<Citizen> residents = new ArrayList<>();

    public Building() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public Integer getBudgetLevel() {
        return budgetLevel;
    }

    public void setBudgetLevel(Integer budgetLevel) {
        this.budgetLevel = budgetLevel;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<Citizen> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Citizen> workers) {
        this.workers = workers;
    }

    public List<Citizen> getResidents() {
        return residents;
    }

    public void setResidents(List<Citizen> residents) {
        this.residents = residents;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", buildingType=" + (buildingType != null ? buildingType.toString() : "null") +
                ", budgetLevel=" + budgetLevel +
                ", isActive=" + isActive +
                ", workersCount=" + (workers != null ? workers.size() : 0) +
                ", residentsCount=" + (residents != null ? residents.size() : 0) +
                '}';
    }
}
