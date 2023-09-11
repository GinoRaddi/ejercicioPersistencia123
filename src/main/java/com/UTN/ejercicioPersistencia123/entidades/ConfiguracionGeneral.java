package com.UTN.ejercicioPersistencia123.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfiguracionGeneral extends BaseEntidad {
    private int cantidadCocineros;
    private String emailEmpresa;
    private String tokenMercadoPago;
}
