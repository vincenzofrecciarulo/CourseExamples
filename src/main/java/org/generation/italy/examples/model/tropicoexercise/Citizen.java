package org.generation.italy.examples.model.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Citizen")
public class Citizen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name",length = 50)
    private String firstName;
    @Column(name = "last_name",length = 50)
    private String lastname;
    @Column(name = "gender",length = 1)
     private Character gender;
    @Column(name = "age")
     private int age;
    @Column(name = "education_level",length = 20)
     private String educationLevel;
    @Column(name = "salary")
    private BigDecimal salary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_building_id")
     private int jobBuildingId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="home_building_id")
    Building homeBuilding;
    @Column(name = "wealth_level",length = 20)
    String wealthLevel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supported_faction_id")
    Faction supportedFaction;
    @Column(name = "is_rebel")
    private Boolean isRebel;
    @Column(name= "happiness_total")
    private Integer happinessTotal;

    public Citizen(){

    }

    public Citizen(int id, String firstName, String lastname, Character gender, int age, String educationLevel, BigDecimal salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.educationLevel = educationLevel;
        this.salary = salary;
    }



    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public Character getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
