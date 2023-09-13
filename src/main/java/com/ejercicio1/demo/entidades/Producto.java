package com.ejercicio1.demo.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends BaseEntidad{
    enum tipo{
        manufacturado,
        insumo
    }
    private Integer tiempoEstimadoCocina;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMinimo;
    private String unidadMedida;
    private String receta;

}
