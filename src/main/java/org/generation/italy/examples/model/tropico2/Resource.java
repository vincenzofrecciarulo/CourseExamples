package org.generation.italy.examples.model.tropico2;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "base_market_price")
    private BigDecimal baseMarketPrice;

    @Column(name = "is_processed")
    private Boolean isProcessed;

    @OneToMany(mappedBy = "outputResource", fetch = FetchType.LAZY)
    private List<BuildingType> outputBuildingTypes;

    @OneToMany(mappedBy = "inputResource", fetch = FetchType.LAZY)
    private List<BuildingType> inputBuildingTypes;

    public Resource(){

    }
}
