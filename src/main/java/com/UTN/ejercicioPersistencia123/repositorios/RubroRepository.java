package com.UTN.ejercicioPersistencia123.repositorios;

import com.UTN .ejercicioPersistencia123.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro,Long> {



}