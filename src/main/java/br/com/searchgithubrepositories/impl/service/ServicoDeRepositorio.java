package br.com.searchgithubrepositories.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.searchgithubrepositories.api.dto.ListaRepositoriosDTO;
import br.com.searchgithubrepositories.api.dto.RepositorioDTO;
import br.com.searchgithubrepositories.api.service.IServicoDeRepositorio;
import br.com.searchgithubrepositories.impl.exception.BadRequestCustomException;
import br.com.searchgithubrepositories.impl.exception.CustomException;

@Service
public class ServicoDeRepositorio implements IServicoDeRepositorio {
	
	private final RestTemplate restTemplate;

	@Autowired
	private Environment env;

	@Autowired
	public ServicoDeRepositorio(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public ListaRepositoriosDTO buscarRepositorios(String query, int page, int pageSize) {
		try {
			String path = env.getProperty("github-api.path");
			String reqPath = String.format("%s/search/repositories?q=%s&page=%s&per_page=%s", path, query, page, pageSize);
			
			return restTemplate.getForEntity(reqPath, ListaRepositoriosDTO.class).getBody();
		} catch(HttpClientErrorException e) {
			throw new BadRequestCustomException(e.getMessage(), e);
		} catch(Exception e) {
			throw new CustomException(e.getMessage(), e);
		}
	}

	@Override
	public RepositorioDTO buscarRepositorio(String loginUsuario, String nomeRepositorio) {
		try {
			String path = env.getProperty("github-api.path");
			String reqPath = String.format("%s/repos/%s/%s", path, loginUsuario, nomeRepositorio);
			
			return restTemplate.getForEntity(reqPath, RepositorioDTO.class).getBody();
		} catch(HttpClientErrorException e) {
			throw new BadRequestCustomException(e.getMessage(), e);
		} catch(Exception e) {
			throw new CustomException(e.getMessage(), e);
		}
	}
	
}
