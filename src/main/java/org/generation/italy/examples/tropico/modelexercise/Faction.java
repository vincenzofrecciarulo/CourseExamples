package org.generation.italy.examples.tropico.modelexercise;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Faction")
public class Faction {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "supportedFaction")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Citizen> getSupporters() {
        return supporters;
    }

    public void setSupporters(List<Citizen> supporters) {
        this.supporters = supporters;
    }
}
