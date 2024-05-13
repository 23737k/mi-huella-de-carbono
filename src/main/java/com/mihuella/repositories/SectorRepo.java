package com.mihuella.repositories;

import com.mihuella.organizacion.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepo extends JpaRepository<Sector, Integer> {
}
