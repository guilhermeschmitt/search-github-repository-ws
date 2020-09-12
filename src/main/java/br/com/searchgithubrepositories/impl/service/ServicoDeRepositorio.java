package br.com.searchgithubrepositories.impl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.searchgithubrepositories.api.dto.ListaRepositoriosDTO;
import br.com.searchgithubrepositories.api.dto.RepositorioDTO;
import br.com.searchgithubrepositories.api.service.IServicoDeRepositorio;

@Service
public class ServicoDeRepositorio implements IServicoDeRepositorio {

	private final RestTemplate restTemplate;
	private static final Logger log = LoggerFactory.getLogger(ServicoDeRepositorio.class);

	@Autowired
	private Environment env;

	@Autowired
	public ServicoDeRepositorio(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public ListaRepositoriosDTO buscarRepositorios(String query, int page, int pageSize) {
		String path = env.getProperty("github-api.path");
		String reqPath = String.format("%s/search/repositories?q=%s&page=%s&per_page=%s", path, query, page, pageSize);
		
		return restTemplate.getForEntity(reqPath, ListaRepositoriosDTO.class).getBody();
	}

	@Override
	public RepositorioDTO buscarRepositorio(String loginUsuario, String nomeRepositorio) {
		String path = env.getProperty("github-api.path");
		String reqPath = String.format("%s/repos/%s/%s", path, loginUsuario, nomeRepositorio);
		
		return restTemplate.getForEntity(reqPath, RepositorioDTO.class).getBody();
	}
	
}
