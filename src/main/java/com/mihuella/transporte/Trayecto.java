package com.mihuella.transporte;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class Trayecto {
	private String origen;
  private String destino;
  private List<Tramo> tramos;

  public Trayecto(List<Tramo> tramos) {
    this.tramos = tramos;
    this.origen = tramos.get(0).getInicio();
    this.destino = tramos.get(tramos.size()-1).getFin();
  }

  public double calcularHuella() {
    return tramos.stream().mapToDouble(tramo -> tramo.calcularHuella()).sum();
  }
  public void agregarTramo(Tramo tramo){
    tramos.add(tramo);
  }

  public void eliminarTramo(Tramo tramo){
    tramos.remove(tramo);
  }

  public Double calcularDistancia(){
    return tramos.stream().mapToDouble(tramos-> tramos.getDistanciaEnKm()).sum();
  }
}
