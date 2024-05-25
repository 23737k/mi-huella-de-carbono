package com.mihuella.service.impl;

import com.mihuella.fe.Medicion;
import com.mihuella.repositories.MedicionRepo;
import com.mihuella.service.MedicionService;
import org.springframework.stereotype.Service;

@Service
public class MedicionServiceImpl implements MedicionService {
  private final MedicionRepo medicionRepo;

  public MedicionServiceImpl(MedicionRepo medicionRepo) {
    this.medicionRepo = medicionRepo;
  }

  public void registrarMedicion(Medicion medicion) {
    medicionRepo.save(medicion);
  }

}
