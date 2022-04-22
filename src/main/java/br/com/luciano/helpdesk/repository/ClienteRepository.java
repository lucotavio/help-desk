package br.com.luciano.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.luciano.helpdesk.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
