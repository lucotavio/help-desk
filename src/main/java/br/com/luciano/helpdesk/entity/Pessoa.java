package br.com.luciano.helpdesk.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import br.com.luciano.helpdesk.enumeration.Perfil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public abstract class Pessoa {

	@Getter
	@Setter
	protected Integer id;
	
	@Getter
	@Setter
	protected String nome;
	
	@Getter
	@Setter
	protected String cpf;
	
	@Getter
	@Setter
	protected String email;
	
	@Getter
	@Setter
	protected String senha;
	
	protected Set<Integer> perfis = new HashSet<>();	
	
	@Getter
	protected LocalDate dataCriacao = LocalDate.now();
	
	public Pessoa() {
		this(null, null, null, null, null);
	}
	
	
	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.addPerfis(Perfil.CLIENTE);
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream()
				.map(x -> Perfil.toEnum(x))
				.collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
}
