package com.ejercicio1.demo.repositorios;

import com.ejercicio1.demo.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pedidorepository extends JpaRepository<Pedido, Long >{
}
