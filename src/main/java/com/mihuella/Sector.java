package com.mihuella;

import lombok.Getter;
import lombok.Setter;

public class Sector {
	@Getter @Setter
  private String nombre;

  public Sector(String nombre) {
    this.nombre = nombre;
  }
}
