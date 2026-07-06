package org.generation.italy.examples.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Resource")
public class Resource implements Serializable {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "base_market_price")
    private BigDecimal baseMarketPrice;

    @Column(name = "is_processed")
    private boolean isProcessed;

    @OneToMany(mappedBy = "inputResoruce", fetch = FetchType.LAZY)
    private List<BuildingType> inputFor =new ArrayList<>();

    @OneToMany(mappedBy = "outputResource", fetch = FetchType.LAZY)
    private List<BuildingType> outputFor= new ArrayList<>();

    public Resource(){}


}
