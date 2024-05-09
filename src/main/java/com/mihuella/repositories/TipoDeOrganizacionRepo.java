package com.mihuella.repositories;

import com.mihuella.organizacion.TipoDeOrganizacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeOrganizacionRepo extends JpaRepository<TipoDeOrganizacion, Integer> {

  Optional<TipoDeOrganizacion> findByNombre(String nombre);
}
