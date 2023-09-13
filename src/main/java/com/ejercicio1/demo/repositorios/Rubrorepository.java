package com.ejercicio1.demo.repositorios;

import com.ejercicio1.demo.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rubrorepository extends JpaRepository<Rubro, Long > {
}
