package com.ejercicio1.demo.repositorios;

import com.ejercicio1.demo.entidades.DetallePedido;
import com.ejercicio1.demo.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Facturarepository extends JpaRepository<Factura, Long > {
}
