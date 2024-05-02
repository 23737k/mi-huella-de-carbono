package com.mihuella.transporte;

import com.mihuella.FactorDeEmision;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TipoDeVehiculo {
  private String nombre;
  private CategoriaVehiculo categoriaVehiculo;
  private FactorDeEmision fe;

  public TipoDeVehiculo(String nombre, CategoriaVehiculo categoriaVehiculo, FactorDeEmision fe) {
    this.nombre = nombre;
    this.categoriaVehiculo = categoriaVehiculo;
    this.fe = fe;
  }
}
