package com.mihuella.dto.request;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizacionRequestDto {
  private String razonSocial;
  private String cuil;
  private String tipoDeOrganizacion;
  private String clasificacion;
  private String direccion;
  private List<SectorRequestDto> sectores = new ArrayList<>();
}