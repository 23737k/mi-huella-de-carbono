package my_app.Mi_Huella;

public class Tramo {
  private UbicacionGeografica inicio;
  private UbicacionGeografica fin;
  private MedioDeTransporte medioDeTransporte;

  public Tramo(UbicacionGeografica inicio, UbicacionGeografica fin, MedioDeTransporte medioDeTransporte) {
    this.inicio = inicio;
    this.fin = fin;
    this.medioDeTransporte = medioDeTransporte;
  }

  //region getters-setters
  public UbicacionGeografica getInicio() {
    return inicio;
  }

  public void setInicio(UbicacionGeografica inicio) {
    this.inicio = inicio;
  }

  public UbicacionGeografica getFin() {
    return fin;
  }

  public void setFin(UbicacionGeografica fin) {
    this.fin = fin;
  }

  public MedioDeTransporte getMedioDeTransporte() {
    return medioDeTransporte;
  }

  public void setMedioDeTransporte(MedioDeTransporte medioDeTransporte) {
    this.medioDeTransporte = medioDeTransporte;
  }

  //endregion getters-setters

}
