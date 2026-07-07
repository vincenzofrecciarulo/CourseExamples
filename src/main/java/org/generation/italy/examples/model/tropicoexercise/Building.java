package org.generation.italy.examples.model.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "building")
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buildingId;
    @Column(name = "budget_level")
    private Integer budget;
    @Column(name="is_active")
    private Boolean isActive;



}
