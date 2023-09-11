package com.UTN.ejercicioPersistencia123.repositorios;

import com.UTN.ejercicioPersistencia123.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {



}
