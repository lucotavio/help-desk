package br.com.luciano.helpdesk.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.luciano.helpdesk.enumeration.Perfil;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PESSOA")
public abstract class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Getter
	@Setter
	@Column(name = "NOME")
	protected String nome;
	
	@Getter
	@Setter
	@Column(name = "CPF", unique = true)
	protected String cpf;
	
	@Getter
	@Setter
	@Column(name = "EMAIL", unique = true)
	protected String email;
	
	@Getter
	@Setter
	@Column(name = "SENHA")
	protected String senha;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();	
	
	@Getter
	@JsonFormat(pattern = "dd/MM/yyyy")
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
