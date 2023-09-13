package com.ejercicio1.demo.repositorios;

import com.ejercicio1.demo.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Clienterepository extends JpaRepository<Cliente, Long >   {
}
