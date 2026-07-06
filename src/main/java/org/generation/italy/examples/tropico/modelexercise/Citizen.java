package org.generation.italy.examples.tropico.modelexercise;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private Building homeBuilding;

    @Column(name = "wealth_level")
    private String wealthLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supported_faction_id")
    private Faction supportedFaction;

    @Column(name = "is_rebel")
    private boolean isRebel;

    @Column(name = "happiness_total")
    private Integer happinesTotal;

    public Citizen (){}

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public Faction getSupportedFaction() {
        return supportedFaction;
    }

    public void setSupportedFaction(Faction supportedFaction) {
        this.supportedFaction = supportedFaction;
    }

    public String getWealthLevel() {
        return wealthLevel;
    }

    public void setWealthLevel(String wealthLevel) {
        this.wealthLevel = wealthLevel;
    }

    public boolean isRebel() {
        return isRebel;
    }

    public void setRebel(boolean rebel) {
        isRebel = rebel;
    }

    public Integer getHappinesTotal() {
        return happinesTotal;
    }

    public void setHappinesTotal(Integer happinesTotal) {
        this.happinesTotal = happinesTotal;
    }
}
