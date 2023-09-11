package com.UTN.ejercicioPersistencia123.repositorios;

import com.UTN.ejercicioPersistencia123.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {



}