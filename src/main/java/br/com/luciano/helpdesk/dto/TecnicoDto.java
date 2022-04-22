package br.com.luciano.helpdesk.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.luciano.helpdesk.entity.Tecnico;
import br.com.luciano.helpdesk.enumeration.Perfil;
import lombok.Getter;
import lombok.Setter;


public class TecnicoDto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private String cpf;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String senha;

	private Set<Integer> perfis = new HashSet<>();	

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao = LocalDate.now();

	public TecnicoDto(Tecnico tecnico) {
		this.id = tecnico.getId();
		this.nome = tecnico.getNome();
		this.cpf = tecnico.getCpf();	
		this.email = tecnico.getEmail();
		this.senha = tecnico.getSenha();
		this.perfis = tecnico.getPerfis()
				.stream()
				.map(t -> t.getCodigo())
				.collect(Collectors.toSet());
		
		this.dataCriacao = tecnico.getDataCriacao();
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream()
				.map(c -> Perfil.toEnum(c))
				.collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}
	
}
