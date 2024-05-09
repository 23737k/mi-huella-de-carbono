package com.mihuella.dto.response;

import java.util.List;

public record OrganizacionResponseDto (
    Integer id, String razonSocial,String cuil, String tipoDeOrganizacion, String clasificacion,
    String direccion, List<SectorResponseDto> sectores
){}
