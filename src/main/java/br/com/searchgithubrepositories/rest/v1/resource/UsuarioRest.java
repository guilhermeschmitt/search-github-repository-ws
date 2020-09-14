package br.com.searchgithubrepositories.rest.v1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.searchgithubrepositories.api.dto.RepositorioDTO;
import br.com.searchgithubrepositories.api.dto.UsuarioDTO;
import br.com.searchgithubrepositories.api.service.IServicoDeUsuario;

@RestController
@RequestMapping(value = "/v1")
public class UsuarioRest {

	@Autowired
	private IServicoDeUsuario servicoDeUsuario;
	
	@GetMapping("/user/{loginUsuario}/repositories")
	public List<RepositorioDTO> buscaUsuarioComRepositorios(
		@RequestParam("page") int page,
		@RequestParam("pageSize") int pageSize,
		@PathVariable(value = "loginUsuario") String loginUsuario
	) {
		return servicoDeUsuario.buscaUsuarioComRepositorios(loginUsuario, page, pageSize);
	}

	@GetMapping("/user/{loginUsuario}")
	public UsuarioDTO buscaInformacoesDoUsuario(@PathVariable(value = "loginUsuario") String loginUsuario) {
		return servicoDeUsuario.buscaInformacoesDoUsuario(loginUsuario);
	}
	
}
