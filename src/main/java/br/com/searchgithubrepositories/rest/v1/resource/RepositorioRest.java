package br.com.searchgithubrepositories.rest.v1.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.searchgithubrepositories.api.dto.ListaRepositoriosDTO;
import br.com.searchgithubrepositories.api.dto.RepositorioDTO;
import br.com.searchgithubrepositories.api.service.IServicoDeRepositorio;

@RestController
@RequestMapping(value = "/v1")
public class RepositorioRest {
	
	@Autowired
	private IServicoDeRepositorio servicoDeRepositorio;
	
	@GetMapping("/repositories")
	public ListaRepositoriosDTO buscarRepositorios(
		@RequestParam("page") int page,
		@RequestParam("query") String query,
		@RequestParam("pageSize") int pageSize
	) {
		return servicoDeRepositorio.buscarRepositorios(query, page, pageSize);
	}
	
	
	//Enviado nome do repositório por query param, porque se ele começar com "." não chegava. Ex: facebook/.github
	@GetMapping("/repository/{loginUsuario}")
	public RepositorioDTO buscaRepositorio(
		@PathVariable(value = "loginUsuario") String loginUsuario,
		@RequestParam(value = "repository") String nomeRepositorio
	) {
		return servicoDeRepositorio.buscarRepositorio(loginUsuario, nomeRepositorio);
	}
	
}
