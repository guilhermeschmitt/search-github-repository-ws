package br.com.searchgithubrepositories.api.service;

import br.com.searchgithubrepositories.api.dto.ListaRepositoriosDTO;
import br.com.searchgithubrepositories.api.dto.RepositorioDTO;

public interface IServicoDeRepositorio {

	public ListaRepositoriosDTO buscarRepositorios(String query, int page, int pageSize);

	public RepositorioDTO buscarRepositorio(String loginUsuario, String nomeRepositorio);

}
