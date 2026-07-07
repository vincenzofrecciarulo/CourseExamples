package org.generation.italy.examples.model.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "resource")
public class Resource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",length = 50)
    private String buildingName;
    @Column(name = "base_market_price")
    private BigDecimal baseMarketPrice;


}
