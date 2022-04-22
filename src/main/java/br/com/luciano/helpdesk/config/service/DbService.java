package br.com.luciano.helpdesk.config.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luciano.helpdesk.entity.Chamado;
import br.com.luciano.helpdesk.entity.Cliente;
import br.com.luciano.helpdesk.entity.Tecnico;
import br.com.luciano.helpdesk.enumeration.Perfil;
import br.com.luciano.helpdesk.enumeration.Prioridade;
import br.com.luciano.helpdesk.enumeration.Status;
import br.com.luciano.helpdesk.repository.ChamadoRepository;
import br.com.luciano.helpdesk.repository.ClienteRepository;
import br.com.luciano.helpdesk.repository.TecnicoRepository;

@Service
public class DbService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		
		Tecnico tecnico1 = new  Tecnico(null, "Valdir Cezar", "352.647.420-65", "valdir@email.com", "123");
		tecnico1.addPerfis(Perfil.ADMIN);
		tecnicoRepository.saveAll(Arrays.asList(tecnico1));
		
		Cliente cliente1 = new Cliente(null, "Linus Torvalds", "992.378.640-43", "torvalds@email.com", "123");
		clienteRepository.saveAll(Arrays.asList(cliente1));
		
		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "primeiro contato", tecnico1, cliente1);
		chamadoRepository.saveAll(Arrays.asList(chamado1));
		
	}

}
