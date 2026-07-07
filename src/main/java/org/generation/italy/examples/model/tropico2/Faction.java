package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faction")
public class Faction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "supportedFaction", fetch = FetchType.LAZY)
    private List<Citizen> citizens = new ArrayList<>();

    public Faction(){

    }
}
