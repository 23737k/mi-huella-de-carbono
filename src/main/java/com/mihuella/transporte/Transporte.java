package com.mihuella.transporte;

import com.mihuella.fe.FactorDeEmision;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "transporte")
public class Transporte {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nombre;
  private String categoriaVehiculo;
  @OneToOne
  private FactorDeEmision factorDeEmision;

  public Transporte(String nombre, String categoriaVehiculo, FactorDeEmision fe) {
    this.nombre = nombre;
    this.categoriaVehiculo = categoriaVehiculo;
    this.factorDeEmision = fe;
  }
}
