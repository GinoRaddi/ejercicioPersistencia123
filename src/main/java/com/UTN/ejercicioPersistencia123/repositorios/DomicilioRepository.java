package com.UTN.ejercicioPersistencia123.repositorios;

import com.UTN.ejercicioPersistencia123.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {



}