package org.generation.italy.examples.model.tropicoEx;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="production_batch")
public class ProductionBatch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(name="production_date")
    private LocalDate productionDate;

    @Column
    private int amount;

    @Column(name="market_value",precision = 10,scale = 2)
    private BigDecimal marketValue;

    public ProductionBatch() {
    }
}
