package com.mihuella.organizacion;

import com.mihuella.miembro.Miembro;
import jakarta.persistence.CascadeType;
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
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lombok
@Getter
@Setter
@NoArgsConstructor
//JPA
@Entity
@Table(name = "sector")
public class Sector {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nombre;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "sector_miembros", joinColumns = {
      @JoinColumn(name = "sector_id"),}, inverseJoinColumns = {@JoinColumn(name = "miembro_id")})
  private List<Miembro> miembros;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "organizacion_id")
  private Organizacion organizacion;

  public Sector(String nombre, Organizacion organizacion) {
    this.nombre = nombre;
    this.miembros = new ArrayList<Miembro>();
    this.organizacion = organizacion;
  }

  public void agregarMiembro(Miembro miembro) {
    this.miembros.add(miembro);
  }

  public void eliminarMiembro(Miembro miembro) {
    this.miembros.remove(miembro);
  }

  public void agregarMiembros(List<Miembro> miembros) {
    this.miembros.addAll(miembros);
  }

  public double calcularHuella() {
    return miembros.stream().mapToDouble(m -> m.calcularHuella(organizacion)).sum();
  }

}
