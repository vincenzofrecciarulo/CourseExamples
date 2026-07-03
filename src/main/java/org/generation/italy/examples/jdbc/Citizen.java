package org.generation.italy.examples.jdbc;

import java.util.Objects;

public class Citizen {
    private int id;
    private String firstName;
    private String lastName;
    private char gender;
    private int age;
    private String educationLevel;
    private double salary;
    private String wealthLevel;
    private boolean isRebel;
    private int happinessTotal;
    private Faction faction;

    public Citizen() {
    }

    public Citizen(String firstName, String lastName, char gender, int age, String educationLevel, double salary) {
        this(0,firstName,lastName,gender,age,educationLevel,salary);
    }
    public Citizen(int id,String firstName, String lastName, char gender, int age, String educationLevel, double salary) {
        this(id,firstName,lastName,gender,age,educationLevel,salary,null,false,0);
    }

    public Citizen(int id, String firstName, String lastName, char gender, int age,
                   String educationLevel, double salary, String wealthLevel, boolean isRebel, int happinessTotal) {
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public int getHappinessTotal() {
        return happinessTotal;
    }

    public void setHappinessTotal(int happinessTotal) {
        this.happinessTotal = happinessTotal;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public int getSupportedFactionId() {
        return faction.getId();
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", educationLevel='" + educationLevel + '\'' +
                ", salary=" + salary +
                ", wealthLevel='" + wealthLevel + '\'' +
                ", isRebel=" + isRebel +
                ", happinessTotal=" + happinessTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return id == citizen.id && gender == citizen.gender && age == citizen.age && Double.compare(salary, citizen.salary) == 0 && isRebel == citizen.isRebel && happinessTotal == citizen.happinessTotal && Objects.equals(firstName, citizen.firstName) && Objects.equals(lastName, citizen.lastName) && Objects.equals(educationLevel, citizen.educationLevel) && Objects.equals(wealthLevel, citizen.wealthLevel) && Objects.equals(faction, citizen.faction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, age, educationLevel, salary, wealthLevel, isRebel, happinessTotal, faction);
    }
}
