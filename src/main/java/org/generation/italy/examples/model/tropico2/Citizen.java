package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Citizen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(length = 1)
    private char gender;

    @Column
    private Integer age;

    @Column
    private String education_level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_building_id")
    private Integer jobBuildingId;

    @Column(precision = 10, scale = 2)
    private double salary;

    @Column(length = 20)
    private String wealthLevel;

    @Column
    private boolean isRebel;

    @Column
    private Integer happinessTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_building_id")
    private Integer homeBuildingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supported_faction_id")
    private Integer supportedFactionId;



    public Citizen(){}

    public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public char getGender() {
        return gender;
    }
    public Integer getAge() {
        return age;
    }
    public String getEducation_level() {
        return education_level;
    }
    public Integer getJobBuildingId() {
        return jobBuildingId;
    }
    public double getSalary() {
        return salary;
    }
    public Integer getHomeBuildingId() {
        return homeBuildingId;
    }

    public String getWealthLevel() {
        return wealthLevel;
    }

    public Integer getSupportedFactionId() {
        return supportedFactionId;
    }
    public boolean isRebel() {
        return isRebel;
    }
    public Integer getHappinessTotal() {
        return happinessTotal;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }
    public void setJobBuildingId(Integer jobBuildingId) {
        this.jobBuildingId = jobBuildingId;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setHomeBuildingId(Integer homeBuildingId) {
        this.homeBuildingId = homeBuildingId;
    }
    public void setWealthLevel(String wealthLevel) {
        this.wealthLevel = wealthLevel;
    }
    public void setSupportedFactionId(Integer supportedFactionId) {
        this.supportedFactionId = supportedFactionId;
    }
    public void setRebel(boolean rebel) {
        isRebel = rebel;
    }
    public void setHappinessTotal(Integer happinessTotal) {
        this.happinessTotal = happinessTotal;
    }
}
