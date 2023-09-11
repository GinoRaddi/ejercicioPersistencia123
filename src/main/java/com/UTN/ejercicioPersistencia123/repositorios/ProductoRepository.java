package com.UTN.ejercicioPersistencia123.repositorios;


import com.UTN.ejercicioPersistencia123.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {



}