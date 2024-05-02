package com.mihuella.service.impl;

import com.mihuella.service.ApiDistanciaService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;


public class ApiDistanciaImpl implements ApiDistanciaService {

  private RestTemplate restTemplate;
  private final String URL = "https://api.distancematrix.ai/maps/api/distancematrix/json";
  private final String KEY = "key=vMfcmmkYwdLfltNDTjqRHbMJlpvbWkfvzRzTZzHwspHzfFWEw5r8HMRSvXRPTfd2";


  public ApiDistanciaImpl() {
    this.restTemplate = new RestTemplateBuilder().build();
  }

  @Override
  public Double calcularDistancia(String origen, String destino) {
    String queryParams = "&origins=" + origen + "&destinations=" + destino;
    String apiUrl = URL + "?" + KEY + queryParams;
    JsonNode response = restTemplate.getForObject(apiUrl, JsonNode.class);
    Double distance;
    if (response != null) {
      JsonNode distanceNode = response.path("rows").get(0).path("elements").get(0).path("distance").path("value");
      distance = distanceNode.asDouble();
    } else {
      throw new RuntimeException("No se encontro el resultado");
    }
    return distance/1000;
  }
}
