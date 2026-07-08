package org.generation.italy.examples.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faction")
public class Faction implements Serializable {
    @Id
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "supportedFaction")
    private List<Citizen> citizens = new ArrayList<>();

    public Faction() {}

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

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", citizensCount=" + (citizens != null ? citizens.size() : 0) +
                '}';
    }
}
