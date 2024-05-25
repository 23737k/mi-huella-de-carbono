package com.mihuella.reportes;
import com.mihuella.fe.Actividad;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActividadHuella {
  private Actividad actividad;
  private Double huella;
  private List<TipoDeConsumoHuella> tipoDeConsumoHuellaList;

  public ActividadHuella(Actividad actividad, Double huella) {
    this.actividad = actividad;
    this.huella = huella;
    this.tipoDeConsumoHuellaList = new ArrayList<TipoDeConsumoHuella>();
  }
  public void addTipoDeConsumoHuella(TipoDeConsumoHuella tipoDeConsumoHuella) {
    this.tipoDeConsumoHuellaList.add(tipoDeConsumoHuella);
  }
}
