package org.generation.italy.examples.model.tropico_ex;


import jakarta.persistence.*;
import org.generation.italy.examples.model.tropico.Building;
import org.generation.italy.examples.model.tropico.Faction;

import java.math.BigDecimal;

@Entity
@Table (name = "citizen")

public class Citizen {

@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
private Integer id;

@Column(name = "first_name", length = 50)
    private String firstName;

@Column(name = "last_name", length = 50)
    private String lastName;

@Column(name = "gender", length = 1)
    private Character gender;

@Column(name = "age")
    private Integer age;

@Column(name = "education_level", length = 20)
    private String educationLevel;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "job_building_id")
    private Building jobBuilding;

@Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "home_building_id")
    private Building homeBuilding;

@Column(name = "wealth_level", length = 20)
    private String wealthLevel;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "supported_faction_id")
    private Faction supportedFaction;

@Column(name = "is_rebel")
    private Boolean isRebel;

@Column(name = "happiness_total")
    private Integer happinessTotal;

    public Citizen() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Building getJobBuilding() {
        return jobBuilding;
    }

    public void setJobBuilding(Building jobBuilding) {
        this.jobBuilding = jobBuilding;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Building getHomeBuilding() {
        return homeBuilding;
    }

    public void setHomeBuilding(Building homeBuilding) {
        this.homeBuilding = homeBuilding;
    }

    public String getWealthLevel() {
        return wealthLevel;
    }

    public void setWealthLevel(String wealthLevel) {
        this.wealthLevel = wealthLevel;
    }

    public Faction getSupportedFaction() {
        return supportedFaction;
    }

    public void setSupportedFaction(Faction supportedFaction) {
        this.supportedFaction = supportedFaction;
    }

    public Boolean getIsRebel() {
        return isRebel;
    }

    public void setIsRebel(Boolean rebel) {
        isRebel = rebel;
    }

    public Integer getHappinessTotal() {
        return happinessTotal;
    }

    public void setHappinessTotal(Integer happinessTotal) {
        this.happinessTotal = happinessTotal;
    }
}
