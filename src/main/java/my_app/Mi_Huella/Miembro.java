package my_app.Mi_Huella;

import java.util.List;

public class Miembro {
  private String nombre;
  private String apellido;
  private TipoDoc tipoDeDocumento;
  private String nroDocumento;
  private List<LugarDeTrabajo> lugaresDeTrabajo;


  public Miembro(String nombre, String apellido, TipoDoc tipoDeDocumento,
                 String nroDocumento,
                 List<LugarDeTrabajo> lugaresDeTrabajo) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.tipoDeDocumento = tipoDeDocumento;
    this.nroDocumento = nroDocumento;
    this.lugaresDeTrabajo = lugaresDeTrabajo;
  }
  //region getters-setters
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public TipoDoc getTipoDeDocumento() {
    return tipoDeDocumento;
  }

  public void setTipoDeDocumento(TipoDoc tipoDeDocumento) {
    this.tipoDeDocumento = tipoDeDocumento;
  }

  public String getNroDocumento() {
    return nroDocumento;
  }

  public void setNroDocumento(String nroDocumento) {
    this.nroDocumento = nroDocumento;
  }

  public List<LugarDeTrabajo> getLugaresDeTrabajo() {
    return lugaresDeTrabajo;
  }

  public void setLugaresDeTrabajo(List<LugarDeTrabajo> lugaresDeTrabajo) {
    this.lugaresDeTrabajo = lugaresDeTrabajo;
  }
  //endregion getters-setters

}
