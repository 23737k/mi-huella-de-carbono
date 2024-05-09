package com.mihuella.repositories;

import com.mihuella.organizacion.Clasificacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasificacionRepo extends JpaRepository<Clasificacion, Integer> {
  Optional<Clasificacion> findByNombre(String nombre);
}
