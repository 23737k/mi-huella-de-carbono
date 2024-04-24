package com.mihuella;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Tramo {
  private UbicacionGeografica inicio;
  private UbicacionGeografica fin;
  private MedioDeTransporte medioDeTransporte;

  public Tramo(UbicacionGeografica inicio, UbicacionGeografica fin, MedioDeTransporte medioDeTransporte) {
    this.inicio = inicio;
    this.fin = fin;
    this.medioDeTransporte = medioDeTransporte;
  }

}
