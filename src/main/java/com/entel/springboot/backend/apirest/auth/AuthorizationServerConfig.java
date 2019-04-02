package com.entel.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	// Los dos endpoint estan protegidos por autentificación via http basic (Header Authorization Basic: Client id + Client secret)
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception { // Configuración de permisos de rutas de acceso
		
		security.tokenKeyAccess("permitAll()") // Permiso para iniciar sesion a todos en el endpoint oauth/token
		.checkTokenAccess("isAuthenticated()"); // Permiso al endpoint que se encarga de validar el token oauth/check_token
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception { // Configuración de aplicaciones que van a acceder al apirest
		
		clients.inMemory().withClient("angularapp").secret(passwordEncoder.encode("123456"))
		.scopes("read", "write")
		.authorizedGrantTypes("password","refresh_token") // code: codigo de autorización | implicita: aplicaciones públicas | refresh_token : Se obtiene nuevo token antes que caduque
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(3600);
		/*
		.and()
		.withClient("androidapp")
		.secret(passwordEncoder.encode("67890"))
		.scopes("read", "write")
		.authorizedGrantTypes("password", "refresh_token")
		.accessTokenValiditySeconds(20000)
		.refreshTokenValiditySeconds(20000);
		*/
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore()) // Opcional => Explicito, por debajo ya lo implementa 
		.accessTokenConverter(accessTokenConverter()); // Encargado de manejar datos del token (autenticación del usuario, roles, etc)
		
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() { // Trabaja con JWT para codificar y decodificar
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		return jwtAccessTokenConverter;
	}
	
	
}
