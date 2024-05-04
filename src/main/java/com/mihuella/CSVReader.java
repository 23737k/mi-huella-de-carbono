package com.mihuella;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


class CSVReader {

  public static List<Medicion> leerMediciones(String ruta) {

    try {
      return new CsvToBeanBuilder(new FileReader(ruta))
          .withType(Medicion.class).build().parse();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static List<FactorDeEmision> leerParametros(String ruta) {

    try {
      return new CsvToBeanBuilder(new FileReader(ruta))
          .withType(FactorDeEmision.class).build().parse();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}