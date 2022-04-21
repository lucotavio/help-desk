package br.com.luciano.helpdesk.entity;

import java.time.LocalDate;
import br.com.luciano.helpdesk.enumeration.Prioridade;
import br.com.luciano.helpdesk.enumeration.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Chamado {
	
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	private Tecnico tecnico;
	private Cliente Cliente;
	
	
	public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, 
			String observacoes, Tecnico tecnico, Cliente cliente) {
		
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		Cliente = cliente;
	}
	
}
