package com.mihuella;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mihuella.service.ApiDistanciaService;
import com.mihuella.service.impl.ApiDistanciaImpl;
import org.junit.jupiter.api.Test;


public class ApiDistanciaTest {

  @Test
  public void calcularDistancia() {
    ApiDistanciaService apiDistanciaService = new ApiDistanciaImpl();
    assertEquals(1.2, apiDistanciaService.calcularDistancia("avenida belgrano 2928,caba","avenida san juan 3002,caba"),0.2);
  }


}
