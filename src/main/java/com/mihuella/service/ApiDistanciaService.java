package com.mihuella.service;

import org.springframework.stereotype.Service;

@Service
public interface ApiDistanciaService {
  Double calcularDistancia(String origen, String destino);
}
