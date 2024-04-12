package my_app.Mi_Huella;

import com.opencsv.bean.CsvBindByName;

public class Parametro {
  @CsvBindByName(column = "tipo-de-consumo")
  private String tipoDeConsumo;
  @CsvBindByName
  private Double fe;

  //CONSTRUCTOR SIN PARAMETROS
  public Parametro() {
  }

  public Parametro(String tipoDeConsumo, Double fe) {
    this.tipoDeConsumo = tipoDeConsumo;
    this.fe = fe;
  }

  //region getters y setters
  public String getTipoDeConsumo() {
    return tipoDeConsumo;
  }

  public void setTipoDeConsumo(String tipoDeConsumo) {
    this.tipoDeConsumo = tipoDeConsumo;
  }

  public Double getFe() {
    return fe;
  }

  public void setFe(Double fe) {
    this.fe = fe;
  }
  //endregion getters y setters
}
