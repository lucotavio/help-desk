package br.com.luciano.helpdesk.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.luciano.helpdesk.enumeration.Prioridade;
import br.com.luciano.helpdesk.enumeration.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CHAMADO")
public class Chamado implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DATA_ABERTURA")
	private LocalDate dataAbertura = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DATA_FECHMENTO")
	private LocalDate dataFechamento;
	
	
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name = "TECNICO_ID")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;
	
	
	public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, 
			String observacoes, Tecnico tecnico, Cliente cliente) {
		
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}
	
}
