package com.mihuella;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sector {
  private String nombre;

  public Sector(String nombre) {
    this.nombre = nombre;
  }
}
