package br.com.gestao.usuarios.app.dto;

import java.time.Instant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleSignOnOAuth2DTO {

	@Schema(description  = "NOME E SOBRE NOME", example = "Roberto Carlos")
	private String fullName;
	
	@Schema(description = "E-MAIL", example = "xxxx@dominio.com")
	private String email;
	
	@Schema(description = "E-MAIL ESTA VERIFICADO", example = "true/false")
	private Boolean emailVerified;
	
	@Schema(description = "DATA DE NASCIMENTO", example = "11/11/2001")
	private String birthdate;
	
	@Schema(description = "NUMERO DO TELEFONE", example = "1111-1111")
	private String phoneNumber;
	
	@Schema(description = "VALIDADOR DO TOKEN", example = "123")
	private String issValidador;
	
	@Schema(description = "REGIÃO DO DONO DA CONTA", example = "123")
	private String locale;
	
	@Schema(description = "DATA DA EXPERIÇÃO DO TOKEN", example = "123")
	private Instant expirationToken;
	
	@Schema(description = "TOKEN so pode ser usado nesse período", example = "123")
	private Instant issuedToken;
	
	@Schema(description = "Valor do token", example = "s4ad4as6d46a5s4d56as")
	private String tokenValue;

}
