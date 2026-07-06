package org.generation.italy.examples.model.tropicoEx;

import jakarta.persistence.*;
import org.hibernate.annotations.Parent;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "citizen")
public class Citizen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name",length=50)
    private String firstname;

    @Column(name="last_name",length=50)
    private String lastname;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Genders gender;

    @Column
    int age;

    @Column(name="education_level")
    @Enumerated(EnumType.STRING)
    private EducationLevels educationLevel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="job_building_id")
    private Building jobBuilding;

    @Column(precision = 10,scale=2)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="home_building_id")
    private Building homeBuilding;

    @Column(name="wealth_level")
    private String wealthLevel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="supported_faction_id")
    private Faction faction;

    @Column(name="is_rebel")
    private Boolean isRebel=false;

    @Column(name="happiness_total")
    private  int happinessTotal;
    public Citizen(){}
}
