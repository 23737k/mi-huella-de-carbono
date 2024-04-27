package com.mihuella;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Transporte {
  private TipoDeTransporte tipoDeTransporte;
  private TipoDeVehiculo tipoDeVehiculo;
  private FactorDeEmision factorDeEmision;

  public Transporte(TipoDeTransporte tipoDeTransporte, TipoDeVehiculo tipoDeVehiculo){
    this.tipoDeTransporte = tipoDeTransporte;
    this.tipoDeVehiculo = tipoDeVehiculo;
    this.factorDeEmision = obtenerFactorDeEmision(tipoDeVehiculo);
  }

  public FactorDeEmision obtenerFactorDeEmision(TipoDeVehiculo tipoDeVehiculo) {
    //TODO obtener de la bd el factor de emision correspondiente
    return new FactorDeEmision(new Actividad("transporte"),new TipoDeConsumo("auto"),5.2,"km");
  }
}
