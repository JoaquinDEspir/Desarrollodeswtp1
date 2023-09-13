package com.ejercicio1.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad{
    public enum Estado {
        iniciado,
        preparacion,
        entregado
    }

    public enum TipoEnvio {
        delivery,
        retira
    }

    private String fecha;
    private Double total;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;
    @OneToOne
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetallePedido(DetallePedido deta) {
        detallePedidos.add(deta);
    }



}

