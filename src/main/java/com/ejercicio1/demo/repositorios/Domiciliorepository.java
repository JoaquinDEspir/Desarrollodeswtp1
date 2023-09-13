package com.ejercicio1.demo.repositorios;
import com.ejercicio1.demo.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Domiciliorepository extends  JpaRepository<Domicilio, Long > {
}
