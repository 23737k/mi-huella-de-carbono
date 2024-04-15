package my_app.Mi_Huella;

import java.util.List;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
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
  
  public static void mostrarCalculoHuella(String[] args) {
	  ArgumentParser parser = ArgumentParsers.newFor("Calculador de HU").build()
		        .defaultHelp(true)
		        .description("Calcula la huella de carbono de un conjunto de mediciones");
		    parser.addArgument("-m", "--mediciones").required(true)
		        .help("Archivo de mediciones");
		    parser.addArgument("-p", "--parametros").required(true)
		        .help("Archivo con parámetros de configuración");
		    Namespace ns = null;
		    try {
		      ns = parser.parseArgs(args);
		    } catch (ArgumentParserException e) {
		      parser.handleError(e);
		      System.exit(1);
		    }

		    List<Medicion> mediciones = CSVReader.leerMediciones(ns.get("mediciones"));
		    List<Parametro> parametros = CSVReader.leerParametros(ns.get("parametros"));

		    System.out.println("-----------------------------Calculo de huella------------------------------------");
		    System.out.println("");
		    System.out.println("Periodicidad: " + mediciones.get(0).getPeriodicidadConsumo());
		    System.out.println("Periodo: " + mediciones.get(0).getPeriodoDeImputacion());
		    System.out.println("");
		    System.out.println("Huella por actividad: ");
		    System.out.println("");

		    for (Medicion medicion : mediciones) {
		      Double huella = CalculoHUFacade.calcularHuellaXMedicion(medicion, parametros);
		      System.out.format("Tipo de Actividad: %15s | Huella: %20.2f kgCO2eq%n", medicion.getTipoDeConsumo(), huella);
		    }
		    System.out.println("");

		    Double huellaTotal = CalculoHUFacade.calcularHuellaTotal(mediciones, parametros);
		    System.out.println("Huella Total = " + huellaTotal/1000000.0 + " millones kgCO2eq");
  }

}
