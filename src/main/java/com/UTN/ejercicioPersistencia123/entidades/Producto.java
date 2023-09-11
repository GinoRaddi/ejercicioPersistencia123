package com.UTN.ejercicioPersistencia123.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto  extends BaseEntidad{
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedia;
    private String foto;
    private String receta;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    public enum Tipo{
        MANUFACTURADO, INSUMO;
    }
}

