package com.UTN.ejercicioPersistencia123.repositorios;

import com.UTN.ejercicioPersistencia123.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {



}