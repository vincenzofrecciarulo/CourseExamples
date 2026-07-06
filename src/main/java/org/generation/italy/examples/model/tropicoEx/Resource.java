package org.generation.italy.examples.model.tropicoEx;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="resource")
public class Resource implements Serializable {
    @Id
    private int id;

    @Column(length=50,nullable=false,unique = true)
    private String name;

    @Column(name="base_market_price",nullable=false,precision = 10,scale = 2)
    private BigDecimal baseMarketPrice;

    @Column(name="is_processed")
    private boolean isProcessed=false;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "inputResource")
    private java.util.List<Buildingtype> inputFor=new java.util.ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "outputResource")
    private java.util.List<Buildingtype> outputFrom=new java.util.ArrayList<>();
    public Resource() {
    }
}

