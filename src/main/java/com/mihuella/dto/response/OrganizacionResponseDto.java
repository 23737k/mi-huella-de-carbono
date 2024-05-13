package com.mihuella.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizacionResponseDto {
  private Integer id;
  private String razonSocial;
  private String cuil;
  private String tipoDeOrganizacion;
  private String clasificacion;
  private String direccion;
  private List<SectorResponseDto> sectores;
}
