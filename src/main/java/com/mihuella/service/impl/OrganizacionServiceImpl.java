package com.mihuella.service.impl;

import com.mihuella.dto.request.OrganizacionRequestDto;
import com.mihuella.dto.response.OrganizacionResponseDto;
import com.mihuella.dto.response.SectorResponseDto;
import com.mihuella.organizacion.Clasificacion;
import com.mihuella.organizacion.Organizacion;
import com.mihuella.organizacion.Sector;
import com.mihuella.organizacion.TipoDeOrganizacion;
import com.mihuella.repositories.ClasificacionRepo;
import com.mihuella.repositories.MedicionRepo;
import com.mihuella.repositories.OrganizacionRepo;
import com.mihuella.repositories.SectorRepo;
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
  private SectorRepo sectorRepo;

  public OrganizacionServiceImpl(OrganizacionRepo organizacionRepo,
                                 ClasificacionRepo clasificacionRepo,
                                 TipoDeOrganizacionRepo tipoDeOrganizacionRepo,
                                 SectorRepo sectorRepo) {
    this.clasificacionRepo = clasificacionRepo;
    this.tipoDeOrganizacionRepo = tipoDeOrganizacionRepo;
    this.organizacionRepo = organizacionRepo;
    this.sectorRepo = sectorRepo;
  }

  @Override
  public Organizacion toOrganizacion(OrganizacionRequestDto dto) {
    TipoDeOrganizacion tipoDeOrganizacion =
        tipoDeOrganizacionRepo.findByNombre(dto.getTipoDeOrganizacion()).orElse(null);
    Clasificacion clasificacion = clasificacionRepo.findByNombre(dto.getClasificacion()).orElse(null);

    if (tipoDeOrganizacion == null || clasificacion == null) {
      throw new RuntimeException("No se ha encontrado la tipo de organizacion o la clasificacion");
    }

    Organizacion organizacion = new Organizacion(
        dto.getRazonSocial(), dto.getCuil(), tipoDeOrganizacion, clasificacion, dto.getDireccion());
    List<Sector> sectores = new ArrayList<>();
    dto.getSectores().forEach(s -> sectores.add(new Sector(s.getNombre(),organizacion)));
    organizacion.setSectores(sectores);
    return organizacion;
  }

  @Override
  public OrganizacionResponseDto toOrganizacionResponseDto(Organizacion organizacion) {

    List<SectorResponseDto> sectoresDtos = new ArrayList<>();
    for (Sector sector : organizacion.getSectores()) {
      sectoresDtos.add(new SectorResponseDto(sector.getId(),sector.getNombre()));
    }

    return new OrganizacionResponseDto(organizacion.getId(),organizacion.getRazonSocial(),
        organizacion.getCuil(),organizacion.getTipoDeOrganizacion().getNombre(),organizacion.getClasificacion().getNombre(),organizacion.getDireccion(),
        sectoresDtos);
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



  @Override
  public Organizacion findById(Integer id){
    Organizacion org = organizacionRepo.findById(id).orElse(null);
    if(org == null) {
      throw new RuntimeException("No se ha encontrado la organizacion");
    }
    return org;
  }

  public List<TipoDeOrganizacion> getTipoDeOrganizaciones() {
    return tipoDeOrganizacionRepo.findAll();
  }
  public List<Clasificacion> getClasificaciones() {
    return clasificacionRepo.findAll();
  }

}
