package org.generation.italy.examples.model.tropico;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Faction")
public class Faction implements Serializable {
    @Id
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "supportedFaction", fetch = FetchType.LAZY)
    private List<Citizen> supporters = new ArrayList<>();

    public Faction() {}

    public Faction(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Citizen> getSupporters() { return supporters; }
    public void setSupporters(List<Citizen> supporters) { this.supporters = supporters; }
}