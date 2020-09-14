package br.com.searchgithubrepositories.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LicencaDTO {

	private String name;
	
}
