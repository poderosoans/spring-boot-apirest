package com.entel.springboot.backend.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.entel.springboot.backend.apirest.models.entity.User;
import com.entel.springboot.backend.apirest.models.services.IUserService;

@Component
public class InfoAditionalToken implements TokenEnhancer{
	@Autowired
	private IUserService iUserService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = iUserService.findByUsername(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("info_aditional", "Hola que tal: ".concat(authentication.getName()));
		info.put("user_name", user.getId()+ ": "+ user.getUsername());
		
		((DefaultOAuth2AccessToken)  accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
