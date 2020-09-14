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
	private Long forks_count;
	private LicencaDTO license;
	private String description;
	private Long watchers_count;
	private Long stargazers_count;
	private Long subscribers_count;
	private Long open_issues_count;
	private ZonedDateTime updated_at;
	private ZonedDateTime created_at;

}
