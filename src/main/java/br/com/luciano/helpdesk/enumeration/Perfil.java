package br.com.luciano.helpdesk.enumeration;

import lombok.Getter;

@Getter
public enum Perfil {

	ABERTO (0, "ROLE_ADMIN"),
	ANDAMENTO (1, "ROLE_CLIENTE"), 
	ENCERRADO (2, "ROLE_TECNICO");
	
	private  Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(Perfil p : Perfil.values()) {
			if(codigo.equals(p.getCodigo())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
		
	}
		
}
