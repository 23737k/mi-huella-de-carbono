package com.mihuella;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

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