package org.generation.italy.examples.model.tropicoEx;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_type_id", nullable = false)
    private Buildingtype buildingtype;

    @Column(name = "budget_level")
    private int budgetLevel = 3;

    @Column(name = "is_active")
    private boolean isActive = true;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "homeBuilding")
    List<Citizen> residents=new ArrayList<>();

    @OneToMany(fetch= FetchType.LAZY,mappedBy = "jobBuilding")
    List<Citizen> employees=new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "building")
    private List<ProductionBatch> productionBatches = new ArrayList<>();

    public Building() {
    }

}
