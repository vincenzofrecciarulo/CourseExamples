package org.generation.italy.examples.model.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "production_batch")
public class ProductionBatch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
