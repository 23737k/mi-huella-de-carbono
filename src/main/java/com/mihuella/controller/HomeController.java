package com.mihuella.controller;

import com.mihuella.dto.response.OrganizacionResponseDto;
import com.mihuella.dto.response.SectorResponseDto;
import com.mihuella.organizacion.Sector;
import com.mihuella.service.OrganizacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  private OrganizacionService orgService;

  public HomeController(OrganizacionService orgService) {
    this.orgService = orgService;
  }

  @RequestMapping("/")
  public String home() {
    return "home";
  }
  @RequestMapping("organizaciones")
  public String organizaciones(Model model){
    model.addAttribute("organizaciones", orgService.findAll());
    return "organizaciones";
  }

  @RequestMapping("organizaciones/{id}")
  public String organizacionesDetalle(@PathVariable("id") Integer id, Model model){
    OrganizacionResponseDto organizacion = orgService.findById(id);
    model.addAttribute("organizacion", organizacion);
    return "organizacionDetalle";
  }

  @RequestMapping("organizaciones/crearOrganizacion")
  public String crearOrganizacion(Model m){

    m.addAttribute("organizacionSeleccionada", new OrganizacionResponseDto());
    m.addAttribute("sectorSeleccionado", new SectorResponseDto());
    m.addAttribute("organizaciones", orgService.findAll());

    return "crearOrganizacion";
  }


}
