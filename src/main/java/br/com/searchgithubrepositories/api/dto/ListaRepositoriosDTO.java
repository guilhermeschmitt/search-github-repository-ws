package br.com.searchgithubrepositories.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaRepositoriosDTO {

	private Long total_count;
	private List<RepositorioDTO> items;
	
}
