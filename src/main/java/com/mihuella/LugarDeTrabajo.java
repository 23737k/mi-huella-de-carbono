package com.mihuella;

public class LugarDeTrabajo {
  private Organizacion organizacion;
  private Area area;

  public LugarDeTrabajo(Organizacion organizacion, Area area) {
    this.organizacion = organizacion;
    this.area = area;
  }

  //region getters-setters
  public Organizacion getOrganizacion() {
    return organizacion;
  }

  public void setOrganizacion(Organizacion organizacion) {
    this.organizacion = organizacion;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }
  //endregion getters-setters
}
