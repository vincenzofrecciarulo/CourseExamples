package org.generation.italy.examples.model.tropicoEx;

import jakarta.persistence.*;

@Entity
@Table(name = "Resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
