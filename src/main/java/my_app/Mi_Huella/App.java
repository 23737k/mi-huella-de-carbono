package my_app.Mi_Huella;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;


public class App {
  public static void main(String[] args) {


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

class CSVReader {

  public static List<Medicion> leerMediciones(String ruta) {

    try {
      return new CsvToBeanBuilder(new FileReader(ruta))
          .withType(Medicion.class).build().parse();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static List<Parametro> leerParametros(String ruta) {

    try {
      return new CsvToBeanBuilder(new FileReader(ruta))
          .withType(Parametro.class).build().parse();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

