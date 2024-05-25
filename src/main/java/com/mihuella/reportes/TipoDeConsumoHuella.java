package com.mihuella.reportes;

import com.mihuella.fe.TipoDeConsumo;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDeConsumoHuella {
  private TipoDeConsumo tipoDeConsumo;
  private Double huella;

}
