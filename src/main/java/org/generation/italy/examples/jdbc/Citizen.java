package org.generation.italy.examples.jdbc;

public class Citizen {
    private int id;
    private String firstName;
    private String lastName;
    private char gender;
    private int age;
    private String educationLevel;
    private Integer jobBuildingId;
    private double salary;
    private Integer homeBuildingId;
    private String wealthLevel;
    private Integer supportedFactionId;
    private boolean isRebel;
    private int happinessTotal;

    public Citizen() {
    }

    public Citizen(String firstName, String lastName, char gender, int age, double salary, String educationLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.educationLevel = educationLevel;
    }

    public Citizen(int id, String firstName, String lastName, char gender, int age,
                   String educationLevel, Integer jobBuildingId, double salary,
                   Integer homeBuildingId, String wealthLevel, Integer supportedFactionId,
                   boolean isRebel, int happinessTotal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.educationLevel = educationLevel;
        this.jobBuildingId = jobBuildingId;
        this.salary = salary;
        this.homeBuildingId = homeBuildingId;
        this.wealthLevel = wealthLevel;
        this.supportedFactionId = supportedFactionId;
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

    public Integer getJobBuildingId() {
        return jobBuildingId;
    }

    public void setJobBuildingId(Integer jobBuildingId) {
        this.jobBuildingId = jobBuildingId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getHomeBuildingId() {
        return homeBuildingId;
    }

    public void setHomeBuildingId(Integer homeBuildingId) {
        this.homeBuildingId = homeBuildingId;
    }

    public String getWealthLevel() {
        return wealthLevel;
    }

    public void setWealthLevel(String wealthLevel) {
        this.wealthLevel = wealthLevel;
    }

    public Integer getSupportedFactionId() {
        return supportedFactionId;
    }

    public void setSupportedFactionId(Integer supportedFactionId) {
        this.supportedFactionId = supportedFactionId;
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

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", educationLevel='" + educationLevel + '\'' +
                ", jobBuildingId=" + jobBuildingId +
                ", salary=" + salary +
                ", homeBuildingId=" + homeBuildingId +
                ", wealthLevel='" + wealthLevel + '\'' +
                ", supportedFactionId=" + supportedFactionId +
                ", isRebel=" + isRebel +
                ", happinessTotal=" + happinessTotal +
                '}';
    }
}
