package com.mihuella.transporte;

import com.mihuella.miembro.Miembro;
import com.mihuella.service.ApiDistanciaService;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "tramo")
public class Tramo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String inicio;
  private String fin;
  private Double distanciaEnKm;
  @ManyToOne(fetch = FetchType.LAZY)
  private Transporte transporte;
  private boolean esCompartido;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "tramo_pasajero", joinColumns = {@JoinColumn(name = "tramo_id")},
      inverseJoinColumns = {@JoinColumn(name = "pasajero_id")})
  private List<Miembro> pasajeros;

  public Tramo(String inicio, String fin, Transporte transporte, ApiDistanciaService apiDistanciaService) {
    this.inicio = inicio;
    this.fin = fin;
    this.transporte = transporte;
    this.pasajeros = new ArrayList<Miembro>();
    this.esCompartido = false;
    this.distanciaEnKm = apiDistanciaService.calcularDistancia(inicio, fin);
  }
  public Tramo(String inicio, String fin, Transporte transporte,ApiDistanciaService apiDistanciaService, List<Miembro> compartidoCon) {
    this.inicio = inicio;
    this.fin = fin;
    this.transporte = transporte;
    this.esCompartido = true;
    this.pasajeros.addAll(compartidoCon);
    this.distanciaEnKm = apiDistanciaService.calcularDistancia(inicio, fin);
  }

  public Double calcularHuella(){
    double huella = distanciaEnKm * transporte.getFactorDeEmision().getValor();
    //Logica de si es compartido
    return esCompartido ? huella/(pasajeros.size()+1) : huella;
  }

}
