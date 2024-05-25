package com.mihuella.controller.mvc;

import com.mihuella.fe.Medicion;
import com.mihuella.service.ActividadService;
import com.mihuella.service.MedicionService;
import com.mihuella.service.OrganizacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mediciones")
public class MedicionesController {
  private final OrganizacionService orgService;
  private final ActividadService actividadService;
  private final MedicionService medicionService;

  public MedicionesController(OrganizacionService organizacionService, ActividadService actividadService, MedicionService medicionService) {
    this.orgService = organizacionService;
    this.actividadService = actividadService;
    this.medicionService = medicionService;
  }


  @GetMapping("/formulario")
  public String medicionFormulario(Model model){
    model.addAttribute("medicion", new Medicion());
    model.addAttribute("actividades",actividadService.getActividades());
    model.addAttribute("organizaciones", orgService.findAll());
    return "medicionFormulario";
  }

  @PostMapping("/procesar-formulario")
  public String crearMedicion(@ModelAttribute("medicion")Medicion medicion){
    medicionService.registrarMedicion(medicion);
    return "redirect:/organizaciones";
  }

}
