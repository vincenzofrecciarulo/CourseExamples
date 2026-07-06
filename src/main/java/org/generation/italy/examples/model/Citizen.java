package org.generation.italy.examples.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @Column(name = "gender")
    private char gender;

    @Column(name = "age")
    private int age;

    @Column(name = "education_level")
    private String educationLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_building_id")
    private Building jobBuilding;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_building_id")
    private Building homeBuiliding;

    @Column(name = "wealth_level")
    private String wealthLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supported_faction_id")
    private Integer supportedFaction;

    @Column(name = "is_rebel")
    private boolean isRebel;

    @Column(name = "happiness_total")
    private Integer happinessTotal;

    public Citizen(){}
}
