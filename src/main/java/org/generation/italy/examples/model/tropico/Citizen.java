package org.generation.italy.examples.model.tropico;

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

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "gender", length = 1)
    private char gender; // CHAR(1)

    @Column(name = "age")
    private int age;

    @Column(name = "education_level", length = 20)
    private String educationLevel;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_building_id")
    private Building jobBuilding;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_building_id")
    private Building homeBuilding;

    @Column(name = "wealth_level", length = 20)
    private String wealthLevel;

    @Column(name = "is_rebel")
    private Boolean isRebel;

    @Column(name = "happiness_total")
    private Integer happinessTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supported_faction_id")
    private Faction supportedFaction;

    public Citizen() {
    }

    public Citizen(String firstName, String lastName, char gender, int age, double salary, String educationLevel) {
        this(firstName, lastName, gender, age, moneyFromDouble(salary), educationLevel);
    }

    public Citizen(String firstName, String lastName, char gender, int age, BigDecimal salary, String educationLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.educationLevel = educationLevel;
    }

    public Citizen(int id, String firstName, String lastName, char gender, int age,
                   String educationLevel, double salary, String wealthLevel, boolean isRebel, int happinessTotal) {
        this(id, firstName, lastName, gender, age, educationLevel, moneyFromDouble(salary), wealthLevel, isRebel, happinessTotal);
    }

    public Citizen(int id, String firstName, String lastName, char gender, int age,
                   String educationLevel, BigDecimal salary, String wealthLevel, boolean isRebel, int happinessTotal) {
        this(id, firstName, lastName, gender, age, educationLevel, salary, wealthLevel, Boolean.valueOf(isRebel), Integer.valueOf(happinessTotal));
    }

    public Citizen(int id, String firstName, String lastName, char gender, int age,
                   String educationLevel, BigDecimal salary, String wealthLevel, Boolean isRebel, Integer happinessTotal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.educationLevel = educationLevel;
        this.salary = salary;
        this.wealthLevel = wealthLevel;
        this.isRebel = isRebel;
        this.happinessTotal = happinessTotal;
    }

    public Citizen(String name, String surname, char gender, int age, String educationLevel, BigDecimal salary, String wealthLevel, boolean isRebel, int happiness) {
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getEducationLevel() { return educationLevel; }
    public void setEducationLevel(String educationLevel) { this.educationLevel = educationLevel; }
    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }
    public void setSalary(double salary) { this.salary = moneyFromDouble(salary); }
    public Building getJobBuilding() { return jobBuilding; }
    public void setJobBuilding(Building jobBuilding) { this.jobBuilding = jobBuilding; }
    public Building getHomeBuilding() { return homeBuilding; }
    public void setHomeBuilding(Building homeBuilding) { this.homeBuilding = homeBuilding; }
    public String getWealthLevel() { return wealthLevel; }
    public void setWealthLevel(String wealthLevel) { this.wealthLevel = wealthLevel; }
    public Boolean isRebel() { return isRebel; }
    public void setRebel(Boolean rebel) { this.isRebel = rebel; }
    public Integer getHappinessTotal() { return happinessTotal; }
    public void setHappinessTotal(Integer happinessTotal) { this.happinessTotal = happinessTotal; }
    public Faction getSupportedFaction() { return supportedFaction; }
    public void setSupportedFaction(Faction supportedFaction) { this.supportedFaction = supportedFaction; }

    private static BigDecimal moneyFromDouble(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", educationLevel='" + educationLevel + '\'' +
                ", salary=" + salary +
                ", wealthLevel='" + wealthLevel + '\'' +
                ", isRebel=" + isRebel +
                ", happinessTotal=" + happinessTotal +
                '}';
    }
}
