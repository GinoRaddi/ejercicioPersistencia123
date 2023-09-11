package com.UTN.ejercicioPersistencia123.repositorios;

import com.UTN.ejercicioPersistencia123.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {


}



