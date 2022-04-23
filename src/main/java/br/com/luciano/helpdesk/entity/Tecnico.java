package br.com.luciano.helpdesk.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.luciano.helpdesk.dto.TecnicoDto;
import br.com.luciano.helpdesk.enumeration.Perfil;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TECNICO")
public class Tecnico extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@JsonIgnore
	@OneToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<>();
	
	
	public Tecnico() {
		this(null, null, null, null, null);
	}
	
	
	
	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id,nome, cpf, email, senha);
		this.chamados = new ArrayList<>();
	}
	
	public Tecnico(TecnicoDto tecnicoDto) {
		this.id = tecnicoDto.getId();
		this.nome = tecnicoDto.getNome();
		this.cpf = tecnicoDto.getCpf();	
		this.email = tecnicoDto.getEmail();
		this.senha = tecnicoDto.getSenha();
		this.perfis = tecnicoDto.getPerfis()
				.stream()
				.map(t -> t.getCodigo())
				.collect(Collectors.toSet());
		
		this.dataCriacao = tecnicoDto.getDataCriacao();
		
		addPerfis(Perfil.CLIENTE);
	}

}
