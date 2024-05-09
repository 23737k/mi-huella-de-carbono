package com.mihuella.service.impl;

import com.mihuella.dto.request.OrganizacionRequestDto;
import com.mihuella.organizacion.Clasificacion;
import com.mihuella.organizacion.Organizacion;
import com.mihuella.organizacion.Sector;
import com.mihuella.organizacion.TipoDeOrganizacion;
import com.mihuella.repositories.ClasificacionRepo;
import com.mihuella.repositories.OrganizacionRepo;
import com.mihuella.repositories.TipoDeOrganizacionRepo;
import com.mihuella.service.OrganizacionService;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {
  private ClasificacionRepo clasificacionRepo;
  private TipoDeOrganizacionRepo tipoDeOrganizacionRepo;
  private OrganizacionRepo organizacionRepo;

  public OrganizacionServiceImpl(OrganizacionRepo organizacionRepo,
                                 ClasificacionRepo clasificacionRepo,
                                 TipoDeOrganizacionRepo tipoDeOrganizacionRepo) {
    this.clasificacionRepo = clasificacionRepo;
    this.tipoDeOrganizacionRepo = tipoDeOrganizacionRepo;
    this.organizacionRepo = organizacionRepo;
  }

  @Override
  public Organizacion toOrganizacion(OrganizacionRequestDto dto) {
    TipoDeOrganizacion tipoDeOrganizacion =
        tipoDeOrganizacionRepo.findByNombre(dto.tipoDeOrganizacion()).orElse(null);
    Clasificacion clasificacion = clasificacionRepo.findByNombre(dto.clasificacion()).orElse(null);

    if (tipoDeOrganizacion == null || clasificacion == null) {
      throw new RuntimeException("No se ha encontrado la tipo de organizacion o la clasificacion");
    }

    Organizacion organizacion = new Organizacion(
        dto.razonSocial(), dto.cuil(), tipoDeOrganizacion, clasificacion, dto.direccion());
    List<Sector> sectores = new ArrayList<>();
    dto.sectores().forEach(s -> sectores.add(new Sector(s.nombre(),organizacion)));
    organizacion.setSectores(sectores);
    return organizacion;
  }

  @Override
  @Transactional
  public OrganizacionRequestDto save(OrganizacionRequestDto organizacion) {
    organizacionRepo.save(toOrganizacion(organizacion));
    return organizacion;
  }

  @Override
  public List<Organizacion> findAll() {
    return organizacionRepo.findAll();
  }
}
