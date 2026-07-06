package org.generation.italy.examples.model;


import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "production_batch")
public class ProductionBatch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(name = "production_date")
    private LocalDate productionDate;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "market_value")
    private BigDecimal marketValue;

    public ProductionBatch(){}


}
