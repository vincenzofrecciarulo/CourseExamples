package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;
import org.generation.italy.examples.model.tropico2.Building;
import org.generation.italy.examples.model.tropico2.Faction;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Citizen")
public class Citizen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender", length = 1)
    private char gender;

    @Column(name = "age")
    private int age;

    @Column(name = "education_level")
    private String educationLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_building_id")
    private Building jobBuilding;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_building_id")
    private Building homeBuilding;

    @Column(name = "wealth_level")
    private String wealthLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supported_faction_id")
    private Faction supportedFaction;

    @Column(name = "is_rebel")
    private boolean isRebel;

    @Column(name = "happiness_total")
    private Integer happinessTotal;

    public Citizen(){

    }
}
