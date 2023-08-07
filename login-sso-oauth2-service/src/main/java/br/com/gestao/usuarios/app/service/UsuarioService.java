package br.com.gestao.usuarios.app.service;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
// import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import br.com.gestao.usuarios.app.dto.SingleSignOnOAuth2DTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {

	public SingleSignOnOAuth2DTO cookie(OidcUser oidcUser) {

		log.info(" Inicializando o cookie service");

		SingleSignOnOAuth2DTO singleSignOnOAuth2DTO = new SingleSignOnOAuth2DTO();

		singleSignOnOAuth2DTO.setEmail(oidcUser.getAttribute("email"));
		singleSignOnOAuth2DTO.setFullName(oidcUser.getFullName());
		singleSignOnOAuth2DTO.setIssValidador(oidcUser.getClaimAsString("iss"));
		singleSignOnOAuth2DTO.setPhoneNumber(oidcUser.getPhoneNumber());
		singleSignOnOAuth2DTO.setBirthdate(oidcUser.getBirthdate());
		singleSignOnOAuth2DTO.setEmailVerified(oidcUser.getEmailVerified());
		singleSignOnOAuth2DTO.setLocale(oidcUser.getClaimAsString("locale"));
		singleSignOnOAuth2DTO.setTokenValue(oidcUser.getIdToken().getTokenValue());
		singleSignOnOAuth2DTO.setExpirationToken(oidcUser.getIdToken().getExpiresAt());
		singleSignOnOAuth2DTO.setIssuedToken(oidcUser.getIdToken().getIssuedAt());
		
		return singleSignOnOAuth2DTO;

	}

	public SingleSignOnOAuth2DTO jwt(Jwt jwt) {

		log.info(" Inicializando o jwt service");

		SingleSignOnOAuth2DTO singleSignOnOAuth2DTO = new SingleSignOnOAuth2DTO();

		singleSignOnOAuth2DTO.setEmail(jwt.getClaimAsString("email"));
		singleSignOnOAuth2DTO.setFullName(jwt.getClaimAsString("name"));
		singleSignOnOAuth2DTO.setIssValidador(jwt.getClaimAsString("iss"));
		singleSignOnOAuth2DTO.setEmailVerified(jwt.getClaimAsBoolean("email_verified"));
		singleSignOnOAuth2DTO.setLocale(jwt.getClaimAsString("locale"));
		singleSignOnOAuth2DTO.setTokenValue(jwt.getTokenValue());
		singleSignOnOAuth2DTO.setExpirationToken(jwt.getExpiresAt());
		singleSignOnOAuth2DTO.setIssuedToken(jwt.getIssuedAt());

		return singleSignOnOAuth2DTO;

	}
}
