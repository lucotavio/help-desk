package br.com.luciano.helpdesk.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PESSOA")
public class Tecnico extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<>();
	
	
	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id,nome, cpf, email, senha);
	}

}
