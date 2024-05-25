package com.mihuella.controller.mvc;

import com.mihuella.organizacion.Organizacion;
import com.mihuella.reportes.ActividadHuella;
import com.mihuella.service.OrganizacionService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/huella-de-carbono")
public class HuellaController {
  private final OrganizacionService organizacionService;

  public HuellaController(OrganizacionService organizacionService) {
    this.organizacionService = organizacionService;
  }


  @GetMapping("/nuevo-calculo")
  public String nuevoCalculo(Model model){
    model.addAttribute("organizaciones",organizacionService.findAll());
    return "nuevoCalculo";
  }

  @PostMapping("/resultado-huella")
  public String calculoHuella(@RequestParam(name = "idOrg") Integer idOrg,@RequestParam(name = "desglose") String desglose,Model model){
    Organizacion organizacion = organizacionService.findById(idOrg);

    List<ActividadHuella> reporte = organizacion.obtenerReporteHuellaPorCategoria();
    model.addAttribute("reporte", reporte);
    model.addAttribute("huella",organizacion.calcularHuellaMediciones());
    model.addAttribute("organizacion",organizacion.getRazonSocial());
    return "resultadoHuella";
  }

}
