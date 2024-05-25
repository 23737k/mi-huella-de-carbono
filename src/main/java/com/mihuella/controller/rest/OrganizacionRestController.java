package com.mihuella.controller.rest;

import com.mihuella.dto.request.OrganizacionRequestDto;
import com.mihuella.dto.response.OrganizacionResponseDto;
import com.mihuella.dto.response.SectorResponseDto;
import com.mihuella.organizacion.Organizacion;
import com.mihuella.service.OrganizacionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organizaciones")
public class OrganizacionRestController {

	private final OrganizacionService orgService;

	public OrganizacionRestController(OrganizacionService orgService) {
		this.orgService = orgService;
	}

	@GetMapping("/")
	public List<OrganizacionResponseDto> getOrganizaciones() {
		List<OrganizacionResponseDto> organizaciones = new ArrayList<>();
		for (Organizacion organizacion : orgService.findAll()) {
			organizaciones.add(orgService.toOrganizacionResponseDto(organizacion));
		}
		return organizaciones;
	}

	@PostMapping("/")
	public OrganizacionRequestDto postOrganizacion(@RequestBody OrganizacionRequestDto organizacion) {
		return orgService.save(organizacion);
	}

	@GetMapping("/sectores")
	public List<SectorResponseDto> sectores(@RequestParam("org")Integer id){
		return orgService.toOrganizacionResponseDto(orgService.findById(id)).getSectores();
	}


}
