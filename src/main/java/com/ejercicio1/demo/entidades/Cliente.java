package com.ejercicio1.demo.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente extends BaseEntidad{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    public void  agregarDomicilio(Domicilio domi){
        domicilios.add(domi);
    }

    public void mostrarDomicilios(){
        System.out.println("Domicilios de "+ nombre+" "+ apellido+":");
        for (Domicilio domicilio : domicilios){
            System.out.println("calle: " + domicilio.getCalle()+" numero: "+domicilio.getNumero());
        }

    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedi) {pedidos.add(pedi);}

    public void mostrarPedidos(){
        System.out.println("Pedidos de "+ nombre+" "+ apellido+":");
        for (Pedido pedido : pedidos){
            /* aca hace el pedido a detalle pedido */
        }
    }





}
