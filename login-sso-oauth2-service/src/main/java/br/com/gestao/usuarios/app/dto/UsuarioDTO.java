package br.com.gestao.usuarios.app.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

	private Long idUsuario;
	private String nome;
	private Integer perfil;
}
