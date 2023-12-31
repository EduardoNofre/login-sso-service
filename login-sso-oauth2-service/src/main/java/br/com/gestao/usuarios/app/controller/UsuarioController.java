package br.com.gestao.usuarios.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestao.usuarios.app.dto.SingleSignOnOAuth2DTO;
import br.com.gestao.usuarios.app.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuario")
@Tag(name = "API RESTFUL DO RECURSO", description = "GESTÃO DE USUARIO OAUTH 2 GOOGLE")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Operation(summary = "COOKIE", description = "Cria o Cookie")
	@GetMapping("/cookie")
	public ResponseEntity<SingleSignOnOAuth2DTO> cookie(@AuthenticationPrincipal OidcUser oidcUser) {

		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.cookie(oidcUser));

	}

	@Operation(summary = "JWT", description = "Verifica JWT do usuario ")
	@SecurityRequirement(name = "bearerToken")
	@GetMapping("/jwt")
	public ResponseEntity<SingleSignOnOAuth2DTO> jwt(@AuthenticationPrincipal Jwt jwt) {

		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.jwt(jwt));

	}
}
