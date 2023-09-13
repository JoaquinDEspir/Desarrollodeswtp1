package com.ejercicio1.demo.repositorios;

import com.ejercicio1.demo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productorepository extends JpaRepository<Producto, Long > {
}
