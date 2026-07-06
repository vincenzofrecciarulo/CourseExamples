package org.generation.italy.examples.model.tropicoEx;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Faction")
public class Faction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description")
    private String desctiption;

    @OneToMany(mappedBy = "supportedFaction", fetch = FetchType.LAZY)
    private List<Citizen> supporters = new ArrayList<>();

    public Faction(){}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesctiption() {
        return desctiption;
    }
    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }
    public List<Citizen> getSupporters() {
        return supporters;
    }
    public void setSupporters(List<Citizen> supporters) {
        this.supporters = supporters;
    }
}
