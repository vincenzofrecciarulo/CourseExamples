package org.generation.italy.examples.tropicoexercise;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity // -> va utilizzato per notificare che è un oggetto proveniente da un db
@Table(name = "citizen") // -> Il nome della tabella su cui deve fare riferimento
public class Citizen {
    @Id // -> gli diciamo che questa è PK della tabella
    @GeneratedValue(strategy = GenerationType.IDENTITY) // -> descriviamo come il db genera la PK
    private Integer id;

    @Column(name = "first_name") // -> questo attributo fa riferimento alla colonna con questo determinato nome
    private String firstName;

    @Column(name = "last_name", length = 50) // -> possiamo decidere anche la max lunghezza di quel valore
    private String lastName;

    @Column // -> se il nome è identico possiamo anche evitare di scriverlo
    private char gender;

    @Column
    private int age;

    @Column(name = "education_level")
    private String educationLevel;

    @ManyToOne(fetch = FetchType.LAZY) // -> notifichiamo che c'è una relazione tra le due classi in Java.
    @JoinColumn(name = "job_building_id") // -> notifichiamo su quale colonna dovrà eseguire la join in caso venisse richiesto
    private Building jobBuilding;

    @Column(precision = 10, scale = 2) // -> essendo un valore numeric(10,2) su db gli dobbiamo specificare anche qua come gestire il valore
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_building_id")
    private Building homeBuilding;

    @Column(name = "wealth_name")
    private String wealthLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supported_faction_id")
    private Faction supportedFaction;

    @Column(name = "is_rebel")
    private boolean isRebel;

    @Column(name = "happiness_total")
    private Integer happinessTotal;


    public Citizen(){} // -> costruttore default necessario per Hibernate

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

    public boolean isRebel() {
        return isRebel;
    }

    public void setRebel(boolean rebel) {
        isRebel = rebel;
    }

    public Integer getHappinessTotal() {
        return happinessTotal;
    }

    public void setHappinessTotal(Integer happinessTotal) {
        this.happinessTotal = happinessTotal;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + firstName + ' ' + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", educationLevel='" + educationLevel + '\'' +
                ", salary=" + salary +
                ", wealthLevel='" + wealthLevel + '\'' +
                ", supportedFaction=" + (supportedFaction != null ? supportedFaction.getName() : "null") +
                ", jobBuildingId=" + (jobBuilding != null ? jobBuilding.getId() : "null") +
                ", homeBuildingId=" + (homeBuilding != null ? homeBuilding.getId() : "null") +
                ", isRebel=" + isRebel +
                ", happinessTotal=" + happinessTotal +
                '}';
    }
}
