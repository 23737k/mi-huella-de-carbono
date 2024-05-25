package com.mihuella.service.impl;

import com.mihuella.fe.Actividad;
import com.mihuella.fe.TipoDeConsumo;
import com.mihuella.repositories.ActividadRepo;
import com.mihuella.service.ActividadService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ActividadServiceImpl implements ActividadService {
  private final ActividadRepo actividadRepo;

  public ActividadServiceImpl(ActividadRepo actividadRepo) {
    this.actividadRepo = actividadRepo;
  }

  @Override
  public List<Actividad> getActividades() {
    return actividadRepo.findAll();
  }

  @Override
  public List<TipoDeConsumo> getTiposDeConsumo(Integer actividadId) {
    Actividad actividad = actividadRepo.findById(actividadId).orElse(null);
    if(actividad == null)
      throw new RuntimeException("Actividad no encontrada");

    return actividad.getTiposDeConsumo();
  }


}
