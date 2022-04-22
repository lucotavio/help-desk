package br.com.luciano.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.luciano.helpdesk.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
