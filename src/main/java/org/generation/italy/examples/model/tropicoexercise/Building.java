package org.generation.italy.examples.model.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "building")
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buildingId;
    @Column(name = "budget_level")
    private Integer budget;
    @Column(name="is_active")
    private Boolean isActive;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "building_type_id")
    private BuildingType buildingType;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "job_building_id")
   private List<Citizen> workers;
   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_building_id")
    private List<Citizen> residents;



}
