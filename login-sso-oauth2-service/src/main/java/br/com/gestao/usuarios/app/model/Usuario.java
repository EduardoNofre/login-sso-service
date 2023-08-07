package br.com.gestao.usuarios.app.model;

import lombok.Data;

@Data
public class Usuario {

	private Long idUsuario;
	private String nome;
	private Integer perfil;

}
