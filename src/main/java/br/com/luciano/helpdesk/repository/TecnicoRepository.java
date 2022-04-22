package br.com.luciano.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luciano.helpdesk.entity.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
