package br.com.searchgithubrepositories.api.dto;

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
	private String updated_at;
	private String created_at;
	private LicencaDTO license;
	private String description;
	private Long watchers_count;
	private Long stargazers_count;
	private Long subscribers_count;
	private Long open_issues_count;
	

}
