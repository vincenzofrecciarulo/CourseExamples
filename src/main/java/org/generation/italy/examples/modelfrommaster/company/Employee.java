package org.generation.italy.examples.modelfrommaster.company;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid")
    private Integer id;

    @Column(name = "lastname", length = 20, nullable = false)
    private String lastName;

    @Column(name = "firstname", length = 10, nullable = false)
    private String firstName;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "titleofcourtesy", length = 25, nullable = false)
    private String titleOfCourtesy;

    @Column(name = "birthdate", nullable = false)
    private LocalDateTime birthDate;

    @Column(name = "hiredate", nullable = false)
    private LocalDateTime hireDate;

    @Column(name = "address", length = 60, nullable = false)
    private String address;

    @Column(name = "city", length = 15, nullable = false)
    private String city;

    @Column(name = "region", length = 15)
    private String region;

    @Column(name = "postalcode", length = 10)
    private String postalCode;

    @Column(name = "country", length = 15, nullable = false)
    private String country;

    @Column(name = "phone", length = 24, nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mgrid")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> directReports = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Order> orders = new ArrayList<>();

    public Employee() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getTitleOfCourtesy() { return titleOfCourtesy; }
    public void setTitleOfCourtesy(String titleOfCourtesy) { this.titleOfCourtesy = titleOfCourtesy; }
    public LocalDateTime getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDateTime birthDate) { this.birthDate = birthDate; }
    public LocalDateTime getHireDate() { return hireDate; }
    public void setHireDate(LocalDateTime hireDate) { this.hireDate = hireDate; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }
    public List<Employee> getDirectReports() { return directReports; }
    public void setDirectReports(List<Employee> directReports) { this.directReports = directReports; }
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}
