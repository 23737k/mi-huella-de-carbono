package com.mihuella.service;

import com.mihuella.dto.request.OrganizacionRequestDto;
import com.mihuella.dto.response.OrganizacionResponseDto;
import com.mihuella.organizacion.Clasificacion;
import com.mihuella.organizacion.Organizacion;
import com.mihuella.organizacion.TipoDeOrganizacion;
import java.util.List;

public interface OrganizacionService {
  Organizacion toOrganizacion(OrganizacionRequestDto organizacionRequestDto);
  OrganizacionResponseDto toOrganizacionResponseDto(Organizacion organizacion);

  OrganizacionRequestDto save(OrganizacionRequestDto dto);

  List<Organizacion> findAll();

  Organizacion findById(Integer id);

  List<TipoDeOrganizacion> getTipoDeOrganizaciones();

  List<Clasificacion> getClasificaciones();
}
