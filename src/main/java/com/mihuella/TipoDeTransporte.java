package com.mihuella;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TipoDeTransporte {
  private String nombre;
  private List<TipoDeVehiculo> tipoDeVehiculos;

  public TipoDeTransporte(String nombre, List<TipoDeVehiculo> tipoDeVehiculos) {
    this.nombre = nombre;
    this.tipoDeVehiculos = tipoDeVehiculos;
  }
}
