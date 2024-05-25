package com.mihuella.repositories;

import com.mihuella.fe.Actividad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepo extends JpaRepository<Actividad, Integer> {
  @Override
  Optional<Actividad> findById(Integer integer);
}
