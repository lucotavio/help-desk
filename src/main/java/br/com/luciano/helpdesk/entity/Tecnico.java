package br.com.luciano.helpdesk.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Tecnico extends Pessoa{
	
	private List<Chamado> chamados = new ArrayList<>();
	
	
	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id,nome, cpf, email, senha);
	}

}
