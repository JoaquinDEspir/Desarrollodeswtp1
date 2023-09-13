package com.ejercicio1.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{
    private Integer numero;
    private String fecha;
    private Integer descuento;
    private Integer total;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    public enum FormaPago {
        efectivo,
        debito,
        credito,
        app
    }
}

