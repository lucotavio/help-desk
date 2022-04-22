package br.com.luciano.helpdesk.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luciano.helpdesk.entity.Tecnico;
import br.com.luciano.helpdesk.repository.TecnicoRepository;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

}