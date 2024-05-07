package com.mihuella.repositories;

import com.mihuella.fe.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
  @Override
  Actividad getReferenceById(Integer aLong);
}
