package my_app.Mi_Huella;

import java.util.List;

public class CalculoHUFacade {

  public static Double calcularHuellaTotal(List<Medicion> mediciones, List<Parametro> parametros){
    Double totalHuella = 0.0;
    for (Medicion medicion : mediciones) {
      try{
        Double huellaMedicion = calcularHuellaXMedicion(medicion,parametros);
        totalHuella += huellaMedicion;
      } catch (Exception e){}
    }
    return totalHuella;
  }

  public static Double calcularHuellaXMedicion(Medicion medicion, List<Parametro> parametros){
    Parametro parametro = parametros.stream().filter(p -> p.getTipoDeConsumo().equals(medicion.getTipoDeConsumo())).findFirst().get();
    if(parametro == null) throw new RuntimeException("no se encontro parametro");
    return medicion.getValorConsumo() * parametro.getFe();
  }

}
