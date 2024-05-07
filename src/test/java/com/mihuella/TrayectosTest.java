package com.mihuella;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mihuella.fe.FactorDeEmision;
import com.mihuella.service.ApiDistanciaService;
import com.mihuella.transporte.Tramo;
import com.mihuella.transporte.Transporte;
import com.mihuella.transporte.Trayecto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TrayectosTest {
  private static FactorDeEmision feAuto;
  private static FactorDeEmision feColectivo;
  private static ApiDistanciaService apiDistancia;
  private static Transporte transporteA;
  private static Transporte transporteB;
  private static Tramo tramoA;
  private static Tramo tramoB;
  private static Trayecto trayecto;

  @BeforeAll
  public static void setUp(){

    feAuto = mock(FactorDeEmision.class);
    feColectivo = mock(FactorDeEmision.class);
    transporteA = mock(Transporte.class);
    transporteB = mock(Transporte.class);
    apiDistancia = mock(ApiDistanciaService.class);

    when(feAuto.getValor()).thenReturn(5.5);
    when(feColectivo.getValor()).thenReturn(2.3);

    when(transporteA.getFactorDeEmision()).thenReturn(feAuto);
    when(transporteB.getFactorDeEmision()).thenReturn(feColectivo);

    when(apiDistancia.calcularDistancia("calle falsa 123", "calle falsa 123")).thenReturn(10.0);
    when(apiDistancia.calcularDistancia("calle falsa 123", "avenida trucha 456")).thenReturn(12.0);

    tramoA = new Tramo("calle falsa 123","calle falsa 123",transporteA,apiDistancia);
    tramoB = new Tramo ("calle falsa 123","avenida trucha 456",transporteB,apiDistancia);

  }

  @Test
  public void calculoHuellaTramo() {
    assertEquals(55.0,(double) tramoA.calcularHuella(),0.01);
    assertEquals(27.6,(double) tramoB.calcularHuella(),0.01);
  }
  @Test
  public void calculoHuellaTrayecto() {
    List<Tramo> tramos = new ArrayList<>();
    tramos.add(tramoA);
    tramos.add(tramoB);
    trayecto = Trayecto.builder().tramos(tramos).build();
    assertEquals(82.6, (double) trayecto.calcularHuella(),0.01);

  }

  @Test
  public void calcularDistanciaTrayecto(){
    List<Tramo> tramos = new ArrayList<>();
    tramos.add(tramoA);
    tramos.add(tramoB);
    trayecto = Trayecto.builder().tramos(tramos).build();
    assertEquals(22.0, trayecto.calcularDistancia(),0.01);
  }

}
