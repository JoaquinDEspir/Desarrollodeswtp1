package com.ejercicio1.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido extends BaseEntidad{
    private Integer cantidad;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "producto_id") // Nombre de la columna que representa la clave foránea
    private Producto producto;

}
