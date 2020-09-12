package br.com.searchgithubrepositories.api.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositorioDTO {

	private Long id;
	private String name;
	private String language;
	private String full_name;
	private UsuarioDTO owner;
	private String description;
	private Long stargazers_count;
	private ZonedDateTime updated_at;
}
