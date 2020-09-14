package br.com.searchgithubrepositories.impl.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.searchgithubrepositories.api.dto.RepositorioDTO;
import br.com.searchgithubrepositories.api.dto.UsuarioDTO;
import br.com.searchgithubrepositories.api.service.IServicoDeUsuario;
import br.com.searchgithubrepositories.impl.exception.BadRequestCustomException;
import br.com.searchgithubrepositories.impl.exception.CustomException;

@Service
public class ServicoDeUsuario implements IServicoDeUsuario {

	private final RestTemplate restTemplate;

	@Autowired
	private Environment env;

	@Autowired
	public ServicoDeUsuario(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public List<RepositorioDTO> buscaUsuarioComRepositorios(String loginUsuario, int page, int pageSize) {
		try {
			String path = env.getProperty("github-api.path");
			String reqPath = String.format("%s/users/%s/repos?page=%s&per_page=%s", path, loginUsuario, page, pageSize);
			
			RepositorioDTO[] arrayDeRepositorios = restTemplate.getForEntity(reqPath, RepositorioDTO[].class).getBody();
			
			return Arrays.asList(arrayDeRepositorios);
		} catch(HttpClientErrorException e) {
			throw new BadRequestCustomException(e.getMessage(), e);
		} catch(Exception e) {
			throw new CustomException(e.getMessage(), e);
		}
	}

	@Override
	public UsuarioDTO buscaInformacoesDoUsuario(String loginUsuario) {
		try {
			String path = env.getProperty("github-api.path");
			String reqPath = String.format("%s/users/%s", path, loginUsuario);
			
			return restTemplate.getForEntity(reqPath, UsuarioDTO.class).getBody();
		} catch(HttpClientErrorException e) {
			throw new BadRequestCustomException(e.getMessage(), e);
		} catch(Exception e) {
			throw new CustomException(e.getMessage(), e);
		}
	}

}
