package com.mihuella.fe;

import com.mihuella.organizacion.Organizacion;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

//Lombok
@Getter
@Setter
@NoArgsConstructor
//JPA
@Entity
@Table(name="medicion")
public class Medicion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  private Actividad actividad;
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  private TipoDeConsumo tipoDeConsumo;
  private Double valorConsumo;
  @Enumerated(EnumType.STRING)
  private Periodicidad periodicidadConsumo;
  private String periodoDeImputacion;
  @ManyToOne(cascade = CascadeType.MERGE)
  private Organizacion organizacion;

  public Medicion(Actividad actividad, TipoDeConsumo tipoDeConsumo, Double valorConsumo,
                  Periodicidad periodicidadConsumo, String periodoDeImputacion, Organizacion organizacion) {
    this.actividad = actividad;
    this.tipoDeConsumo = tipoDeConsumo;
    this.valorConsumo = valorConsumo;
    this.periodicidadConsumo = periodicidadConsumo;
    this.periodoDeImputacion = periodoDeImputacion;
    this.organizacion = organizacion;
  }

  public double calcularHuella(){
    return tipoDeConsumo.getFactorDeEmision().getValor() * valorConsumo;
  }


}

