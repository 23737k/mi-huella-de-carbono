package com.mihuella.controller;

import com.mihuella.dto.request.OrganizacionRequestDto;
import com.mihuella.dto.response.OrganizacionResponseDto;
import com.mihuella.dto.response.SectorResponseDto;
import com.mihuella.service.OrganizacionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organizacion")
public class OrganizacionController {
	private OrganizacionService orgService;

	public OrganizacionController(OrganizacionService orgService) {
		this.orgService = orgService;
	}

	@GetMapping("/")
	public List<OrganizacionResponseDto> getOrganizaciones() {
		return orgService.findAll();
	}

	@PostMapping("/")
	public OrganizacionRequestDto postOrganizacion(@RequestBody OrganizacionRequestDto organizacion) {
		return orgService.save(organizacion);
	}

	@GetMapping("/sectores")
	public List<SectorResponseDto> sectores(@RequestParam("org")Integer id){
		return orgService.findById(id).getSectores();
	}



}
