package com.mihuella.transporte;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaVehiculo {
  private String nombre;

  public CategoriaVehiculo(String nombre) {
    this.nombre = nombre;
  }
}
