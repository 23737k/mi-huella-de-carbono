package com.mihuella.transporte;

import com.mihuella.fe.FactorDeEmision;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Transporte {
  private TipoDeVehiculo tipoDeVehiculo;
  private FactorDeEmision factorDeEmision;

  public Transporte(TipoDeVehiculo tipoDeVehiculo){
    this.tipoDeVehiculo = tipoDeVehiculo;
    this.factorDeEmision = tipoDeVehiculo.getFe();
  }
}
