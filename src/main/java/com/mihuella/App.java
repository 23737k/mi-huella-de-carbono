package com.mihuella;

import com.github.javafaker.Faker;
import com.mihuella.fe.Actividad;
import com.mihuella.fe.FactorDeEmision;
import com.mihuella.fe.Medicion;
import com.mihuella.fe.Periodicidad;
import com.mihuella.fe.TipoDeConsumo;
import com.mihuella.repositories.*;
import jakarta.transaction.Transactional;
import java.util.Locale;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }


}

//@Bean
//@Transactional
//public CommandLineRunner commandLineRunner(FactorDeEmisionRepository repo,
//                                           ActividadRepository aRepo,
//                                           TipoDeConsumoRepository tRepo, MedicionRepository mRepo) {
//  return args -> {
//    // Crear y guardar actividades
//    Actividad a1 = aRepo.save(new Actividad("combustion-fija"));
//    Actividad a2 = aRepo.save(new Actividad("combustion-movil"));
//    Actividad a3 = aRepo.save(new Actividad("electricidad"));
//    Actividad a4 = aRepo.save(new Actividad("transporte"));
//
//    // Obtener tipos de consumo
//    TipoDeConsumo gasNatural = tRepo.save(new TipoDeConsumo("gas-natural"));
//    TipoDeConsumo diesel = tRepo.save(new TipoDeConsumo("diesel"));
//    TipoDeConsumo kerosene = tRepo.save(new TipoDeConsumo("kerosene"));
//    TipoDeConsumo fuelOil = tRepo.save(new TipoDeConsumo("fuelOil"));
//    TipoDeConsumo nafta = tRepo.save(new TipoDeConsumo("nafta"));
//    TipoDeConsumo carbon = tRepo.save(new TipoDeConsumo("carbon"));
//    TipoDeConsumo gasoil = tRepo.save(new TipoDeConsumo("gasoil"));
//    TipoDeConsumo gnc = tRepo.save(new TipoDeConsumo("gnc"));
//    TipoDeConsumo electricidad = tRepo.save(new TipoDeConsumo("electricidad"));
//    TipoDeConsumo auto = tRepo.save(new TipoDeConsumo("auto"));
//    TipoDeConsumo colectivo = tRepo.save(new TipoDeConsumo("colectivo"));
//    TipoDeConsumo moto = tRepo.save(new TipoDeConsumo("moto"));
//    TipoDeConsumo subte = tRepo.save(new TipoDeConsumo("subte"));
//    TipoDeConsumo tren = tRepo.save(new TipoDeConsumo("tren"));
//    TipoDeConsumo taxi = tRepo.save(new TipoDeConsumo("taxi"));
//    TipoDeConsumo bicicleta = tRepo.save(new TipoDeConsumo("bicicleta"));
//    TipoDeConsumo pie = tRepo.save(new TipoDeConsumo("pie"));
//
//
//    // Crear y guardar factores de emisión
//    repo.save(new FactorDeEmision(a1, gasNatural, 1.84, "m3"));
//    repo.save(new FactorDeEmision(a1, diesel, 2.68, "l"));
//    repo.save(new FactorDeEmision(a1, kerosene, 2.5, "l"));
//    repo.save(new FactorDeEmision(a1, fuelOil, 3.1, "l"));
//    repo.save(new FactorDeEmision(a1, nafta, 2.31, "l"));
//    repo.save(new FactorDeEmision(a1, carbon, 2.2, "kg"));
//    repo.save(new FactorDeEmision(a2, gasoil, 2.68, "l"));
//    repo.save(new FactorDeEmision(a2, gnc, 0.77, "l"));
//    repo.save(new FactorDeEmision(a3, electricidad, 0.6, "kwh"));
//    repo.save(new FactorDeEmision(a4, auto, 0.3, "km"));
//    repo.save(new FactorDeEmision(a4, colectivo, 0.15, "km"));
//    repo.save(new FactorDeEmision(a4, moto, 0.2, "km"));
//    repo.save(new FactorDeEmision(a4, subte, 0.065, "km"));
//    repo.save(new FactorDeEmision(a4, tren, 0.065, "km"));
//    repo.save(new FactorDeEmision(a4, taxi, 0.225, "km"));
//    repo.save(new FactorDeEmision(a4, bicicleta, 0.0, "km"));
//    repo.save(new FactorDeEmision(a4, pie, 0.0, "km"));
//    Medicion medicion = new Medicion(a1, gasNatural, 5000.0,
//        Periodicidad.ANUAL, "2023");
//    mRepo.save(medicion);
//  };
//}