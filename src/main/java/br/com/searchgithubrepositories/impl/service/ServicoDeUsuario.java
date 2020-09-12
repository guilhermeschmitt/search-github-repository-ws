package br.com.searchgithubrepositories.impl.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.searchgithubrepositories.api.dto.RepositorioDTO;
import br.com.searchgithubrepositories.api.service.IServicoDeUsuario;

@Service
public class ServicoDeUsuario implements IServicoDeUsuario {

	private final RestTemplate restTemplate;
	private static final Logger log = LoggerFactory.getLogger(ServicoDeUsuario.class);

	@Autowired
	private Environment env;

	@Autowired
	public ServicoDeUsuario(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public List<RepositorioDTO> buscaUsuarioComRepositorios(String loginUsuario, int page, int pageSize) {
		String path = env.getProperty("github-api.path");
		String reqPath = String.format("%s/users/%s/repos?page=%s&per_page=%s", path, loginUsuario, page, pageSize);
		
		RepositorioDTO[] arrayDeRepositorios = restTemplate.getForEntity(reqPath, RepositorioDTO[].class).getBody();
		
		return Arrays.asList(arrayDeRepositorios);
	}

}
