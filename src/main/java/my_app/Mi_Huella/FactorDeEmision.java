package my_app.Mi_Huella;

public class FactorDeEmision {
  private String nombre;
  private Double valor;

  public FactorDeEmision(String nombre, Double valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  //region getters-setters
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }
  //endregion getters-setters
}
