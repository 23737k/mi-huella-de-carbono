package com.mihuella.controller.mvc;

import com.mihuella.dto.request.OrganizacionRequestDto;
import com.mihuella.dto.response.OrganizacionResponseDto;
import com.mihuella.organizacion.Organizacion;
import com.mihuella.service.OrganizacionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/organizaciones")
public class OrganizacionController {

  private final OrganizacionService orgService;

  public OrganizacionController(OrganizacionService organizacionService) {
    this.orgService = organizacionService;
  }

  @GetMapping("")
  public String getOrganizaciones(Model model){
    List<OrganizacionResponseDto> organizaciones = new ArrayList<>();
    for (Organizacion organizacion : orgService.findAll()) {
      organizaciones.add(orgService.toOrganizacionResponseDto(organizacion));
    }
    model.addAttribute("organizaciones", organizaciones);
    return "organizaciones";
  }

  @GetMapping("/{id}")
  public String organizacionesDetalle(@PathVariable("id") Integer id, Model model){
    OrganizacionResponseDto organizacion = orgService.toOrganizacionResponseDto(orgService.findById(id));
    model.addAttribute("organizacion", organizacion);
    return "organizacionDetalle";
  }

  @PostMapping("")
  public String crearOrganizacion(@ModelAttribute("organizacion")OrganizacionRequestDto organizacion){
    organizacion.setClasificacion("ministerio");
    organizacion.setTipoDeOrganizacion("gubernamental");
    orgService.save(organizacion);
    return "redirect:/organizaciones";
  }

  @GetMapping("/formulario")
  public String organizacionFormulario(Model m){

    m.addAttribute("organizacion", new OrganizacionRequestDto());
    m.addAttribute("tiposDeOrganizaciones", orgService.getTipoDeOrganizaciones());
    m.addAttribute("clasificaciones", orgService.getClasificaciones());

    return "organizacionFormulario";
  }

}
