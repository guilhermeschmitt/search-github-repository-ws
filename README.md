### Rodando localmente

Para rodar o backend localmente, você deve:

 - Java 8 instalado
	 - Variável de ambiente ``JAVA_HOME`` configurada
- [Plugin](https://maven.apache.org/download.cgi) do maven instalado
	- Variável de ambiente ``MAVEN_HOME`` [configurada](https://i.stack.imgur.com/ibo5A.png)
	- Path [configurado](https://i.stack.imgur.com/wl0eU.png)
- Clonar este repositório
- Vá para a pasta clonada e:
	- Execute o comando ``mvn spring-boot:run``

### Visão geral das funcionalidades

 - ``/search-github-repositories/api/v1/repository/:userName?repository=:repositoryName``
	 - Busca informações do repositório informado.
- ``/search-github-repositories/api/v1/repositories?query=:query&page=:page&pageSize=:pageSize``
	- Retorna a lista de repositórios buscada a partir da query fornecida.
- ``/search-github-repositories/api/v1/user/:userName/repositories?page=:page&pageSize=:pageSize``
	- Retorna a lista de repositórios do usuário.
- ``/search-github-repositories/api/v1/user/:userName``
	- Retorna informações do usuário.

### Melhorias futuras

 - Tratamento de exceções
 - Utilizar API autenticada, atualmente estou usando sem autenticação e por isso tenho acesso limitado as funcionalidades.
 - Opções de filtro e ordenação na listagem dos repositórios.
