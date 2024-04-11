package my_app.Mi_Huella;

import com.opencsv.bean.CsvBindByName;

public class Medicion {
  @CsvBindByName(column = "actividad")
  private String actividad;
  @CsvBindByName(column = "tipo-de-consumo")
  private String tipoDeConsumo;
  @CsvBindByName(column = "valor-consumo")
  private Double valorConsumo;
  @CsvBindByName(column = "periodicidad-consumo")
  private String periodicidadConsumo;
  @CsvBindByName(column = "periodo-de-imputacion")
  private String periodoDeImputacion;

  public Medicion() {
  }

  //region getters-setters
  public String getActividad() {
    return actividad;
  }

  public void setActividad(String actividad) {
    this.actividad = actividad;
  }

  public String getTipoDeConsumo() {
    return tipoDeConsumo;
  }

  public void setTipoDeConsumo(String tipoDeConsumo) {
    this.tipoDeConsumo = tipoDeConsumo;
  }

  public Double getValorConsumo() {
    return valorConsumo;
  }

  public void setValorConsumo(Double valorConsumo) {
    this.valorConsumo = valorConsumo;
  }

  public String getPeriodicidadConsumo() {
    return periodicidadConsumo;
  }

  public void setPeriodicidadConsumo(String periodicidadConsumo) {
    this.periodicidadConsumo = periodicidadConsumo;
  }

  public String getPeriodoDeImputacion() {
    return periodoDeImputacion;
  }

  public void setPeriodoDeImputacion(String periodoDeImputacion) {
    this.periodoDeImputacion = periodoDeImputacion;
  }
  //endregion getters-setters
}

