package org.generation.italy.examples.model.tropicoEx;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="faction")
public class Faction implements Serializable {
    @Id
    private int id;

    @Column(length = 50,nullable = false,unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "faction")
    private List<Citizen> followers=new ArrayList<>();

    public Faction() {
    }
}
