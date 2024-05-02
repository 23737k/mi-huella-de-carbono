package com.mihuella;

import static org.junit.Assert.assertEquals;

import com.mihuella.service.ApiDistanciaService;
import com.mihuella.service.impl.ApiDistanciaImpl;
import org.junit.Test;


public class ApiDistanciaTest {
  private ApiDistanciaService apiDistanciaService;

  @Test
  public void calcularDistancia() {
    apiDistanciaService = new ApiDistanciaImpl();
    assertEquals(1.9,apiDistanciaService.calcularDistancia("avenida belgrano 2928,caba","avenida san juan 3002,caba"),0.2);
  }


}
