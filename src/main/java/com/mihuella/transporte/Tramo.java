package com.mihuella.transporte;

import com.mihuella.Miembro;
import com.mihuella.service.ApiDistanciaService;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Tramo {
  private String inicio;
  private String fin;
  private Double distanciaEnKm;
  private Transporte transporte;
  private Boolean esCompartido;
  private List<Miembro> compartidoCon;
  private ApiDistanciaService apiDistanciaService;

  public Tramo(String inicio, String fin, Transporte transporte, ApiDistanciaService apiDistanciaService) {
    this.inicio = inicio;
    this.fin = fin;
    this.transporte = transporte;
    this.compartidoCon = new ArrayList<Miembro>();
    this.esCompartido = false;
    this.apiDistanciaService = apiDistanciaService;
    this.distanciaEnKm = calcularDistancia(inicio, fin);
  }
  public Tramo(String inicio, String fin, Transporte transporte,ApiDistanciaService apiDistanciaService, List<Miembro> compartidoCon) {
    this.inicio = inicio;
    this.fin = fin;
    this.transporte = transporte;
    this.esCompartido = true;
    this.compartidoCon.addAll(compartidoCon);
    this.apiDistanciaService = apiDistanciaService;
    this.distanciaEnKm = calcularDistancia(inicio, fin);
  }

  public Double calcularHuella(){
    Double huella = distanciaEnKm * transporte.getFactorDeEmision().getValor();
    //Logica de si es compartido
    return esCompartido ? huella/(compartidoCon.size()+1) : huella;
  }

  public Double calcularDistancia(String inicio, String fin){
    return apiDistanciaService.calcularDistancia(inicio,fin);
  }
}
