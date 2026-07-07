package org.generation.italy.examples.model.tropicoexercise;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "building_type")
public class BuildingType implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "name",length = 50)
  private String name;
  @Column(name = "category",length = 50)
   private String category;
  @Column(name = "construction_cost")
    private Integer construcionCost;
  @Column(name = "maintenance_cost")
    private BigDecimal maintenanceCost;
  @Column(name = "max_workers")
    private Integer maxWorkers;
  @Column(name = "production_rate")
    private BigDecimal productionRate;


}
