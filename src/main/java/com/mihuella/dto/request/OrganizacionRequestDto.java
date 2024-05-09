package com.mihuella.dto.request;
import java.util.List;

public record OrganizacionRequestDto (
    String razonSocial,String cuil, String tipoDeOrganizacion, String clasificacion,
    String direccion, List<SectorRequestDto> sectores){}
