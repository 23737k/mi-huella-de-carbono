package com.mihuella.service;

import com.mihuella.fe.Actividad;
import com.mihuella.fe.TipoDeConsumo;
import java.util.List;

public interface ActividadService {
  List<Actividad> getActividades();
  List<TipoDeConsumo> getTiposDeConsumo(Integer actividadId);
}
