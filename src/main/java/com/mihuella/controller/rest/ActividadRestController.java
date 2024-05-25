package com.mihuella.controller.rest;

import com.mihuella.fe.Actividad;
import com.mihuella.fe.TipoDeConsumo;
import com.mihuella.service.ActividadService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actividades")
public class ActividadRestController {

  private ActividadService actividadService;

  public ActividadRestController(ActividadService actividadService) {
    this.actividadService = actividadService;
  }

  @GetMapping
  public List<Actividad> getActividades() {
    return actividadService.getActividades();
  }

  @GetMapping("/{id}/sectores")
  public List<TipoDeConsumo> getTiposDeConsumo(@PathVariable("id")Integer actividad_id) {
    return actividadService.getTiposDeConsumo(actividad_id);
  }

}
