package org.generation.italy.examples.model.company;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Shippers")
public class Shipper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipperid")
    private Integer id;

    @Column(name = "companyname", length = 40, nullable = false)
    private String companyName;

    @Column(name = "phone", length = 24, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "shipper")
    private List<Order> orders = new ArrayList<>();

    public Shipper() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}
