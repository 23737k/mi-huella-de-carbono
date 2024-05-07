package com.mihuella.transporte;

import com.mihuella.miembro.LugarDeTrabajo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lombok
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//JPA
@Entity
@Table(name = "trayecto")
public class Trayecto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String origen;
  private String destino;
  @Transient
  private List<Tramo> tramos;

  public Trayecto(List<Tramo> tramos) {
    this.tramos = tramos;
    this.origen = tramos.get(0).getInicio();
    this.destino = tramos.get(tramos.size() - 1).getFin();
  }

  public double calcularHuella() {
    return tramos.stream().mapToDouble(Tramo::calcularHuella).sum();
  }

  public void agregarTramo(Tramo tramo) {
    tramos.add(tramo);
  }

  public void eliminarTramo(Tramo tramo) {
    tramos.remove(tramo);
  }

  public Double calcularDistancia() {
    return tramos.stream().mapToDouble(Tramo::getDistanciaEnKm).sum();
  }
}
