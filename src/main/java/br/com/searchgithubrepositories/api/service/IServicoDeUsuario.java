package br.com.searchgithubrepositories.api.service;

import java.util.List;

import br.com.searchgithubrepositories.api.dto.ListaRepositoriosDTO;
import br.com.searchgithubrepositories.api.dto.RepositorioDTO;

public interface IServicoDeUsuario {

	public List<RepositorioDTO> buscaUsuarioComRepositorios(String loginUsuario, int page, int pageSize);

}
