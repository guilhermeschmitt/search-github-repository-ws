package br.com.searchgithubrepositories.api.service;

import java.util.List;

import br.com.searchgithubrepositories.api.dto.RepositorioDTO;
import br.com.searchgithubrepositories.api.dto.UsuarioDTO;

public interface IServicoDeUsuario {

	public List<RepositorioDTO> buscaUsuarioComRepositorios(String loginUsuario, int page, int pageSize);

	public UsuarioDTO buscaInformacoesDoUsuario(String loginUsuario);

}
