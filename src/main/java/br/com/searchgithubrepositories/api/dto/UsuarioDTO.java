package br.com.searchgithubrepositories.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {

	private Long id;
	private String login;
	private String avatar_url;
	
}
