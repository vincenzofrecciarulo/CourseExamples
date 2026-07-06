package org.generation.italy.examples.model.tropico;

import jakarta.persistence.*;
import org.generation.italy.examples.jdbc.DataException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        this.isRebel=false;
        this.happinessTotal=0;
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
    public static Citizen citizenOrm(ResultSet row) throws DataException{
        try{return new Citizen(
                row.getInt("id"),
                row.getString("first_name"),
                row.getString("last_name"),
                row.getString("gender").charAt(0),
                row.getInt("age"),
                row.getString("education_level"),
                row.getDouble("salary"),
                row.getString("wealth_level"),
                row.getBoolean("is_rebel"),
                row.getInt("happiness_total")
        );} catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    public static Citizen generateFromArray(String[] strings) {
        return  new Citizen(
                Integer.parseInt(strings[0].trim()),
                strings[1].trim(),
                strings[2].trim(),
                strings[3].trim().charAt(0),
                Integer.parseInt(strings[4].trim()),
                strings[5].trim(),
                Double.parseDouble(strings[6].trim()),
                strings[7].trim(),
                Boolean.parseBoolean(strings[8].trim()),
                Integer.parseInt(strings[9].trim())
        );
    }

    public String toCsv() {
        return id + "," + firstName + "," + lastName + "," + gender + "," + age + "," + educationLevel + "," + salary + "," + wealthLevel + "," + isRebel + "," + happinessTotal;
    }
}
