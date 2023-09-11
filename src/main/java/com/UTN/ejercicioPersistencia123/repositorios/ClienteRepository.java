package com.UTN.ejercicioPersistencia123.repositorios;


import com.UTN.ejercicioPersistencia123.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {



}
