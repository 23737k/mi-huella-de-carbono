package com.mihuella;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Trayecto {
	@Getter @Setter
  private List<Tramo> tramos;

  public Trayecto(List<Tramo> tramos) {
    this.tramos = tramos;
  }
}
