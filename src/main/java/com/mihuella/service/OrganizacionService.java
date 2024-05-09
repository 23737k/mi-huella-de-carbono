package com.mihuella.service;

import com.mihuella.dto.request.OrganizacionRequestDto;
import com.mihuella.organizacion.Organizacion;
import java.util.List;

public interface OrganizacionService {
  Organizacion toOrganizacion(OrganizacionRequestDto organizacionRequestDto);

  OrganizacionRequestDto save(OrganizacionRequestDto dto);

  List<Organizacion> findAll();
}
