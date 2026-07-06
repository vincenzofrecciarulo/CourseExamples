package org.generation.italy.examples.model;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Faction")

public class Faction implements Serializable{
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "supportedFaction", fetch = FetchType.LAZY)
    private List<Citizen> supporters = new ArrayList<>();

    public Faction(){}

}
