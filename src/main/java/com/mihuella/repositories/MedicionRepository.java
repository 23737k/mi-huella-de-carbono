package com.mihuella.repositories;

import com.mihuella.fe.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicionRepository extends JpaRepository<Medicion, Integer> {
}
