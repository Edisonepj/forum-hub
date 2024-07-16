

<h1 align = "center">
  ForumHub
</h1>
<p align="center">
  <a href="#descrição">Descrição</a> •
  <a href="#funcionalidades">Funcionalidades</a> •
  <a href="#tecnologias-utilizadas">Tecnologias</a> •
  <a href="#como-executar-o-projeto">Como Executar</a> •
  <a href="#screenshots">Screenshots</a> •
  <a href="#observações">Observações</a> •
  <a href="#contribuição">Contribuição</a> •
  <a href="#contato">Contato</a>
</p>

## Descrição
ForumHub é uma API Rest construída com Spring Boot que permite aos usuários gerenciar tópicos e compartilhar ideias em um fórum. 
Cada tópico está associado a um usuário e a um curso. Além disso, a API garante que apenas usuários autenticados possam acessar os recursos.

## Funcionalidades

1. **Criação de tópicos:** Permite criar um novo tópico com `titulo`, `mensagem`, `autorId`, `cursoId`;
2. **Detalhamento de tópico:** Permite detalhar as informações de um tópico (`id`, `titulo`, `mensagem`, `criado_em`, `status`, `autorId` e `cursoId`);
3. **Listagem de tópicos:** Permite listar todos os tópicos cadastrados, contendo as informações detalhadas e 10 resultados por página por padrão;
4. **Atualização de tópico:** Permite atualizar um tópico fornecendo o `id` via url e um JSON com as mesmas propriedades necessárias para a criação de um tópico;
5. **Exclusão de tópico:** Permite deletar um tópico fornecendo o `id`via url 
6. **Autenticação e Autorização:** Implementa um sistema de autenticação e autorização para garantir a segurança da API.

## Diagrama do Banco de Dados

![Imgur](https://i.imgur.com/pHa0PoU.png)

## Endpoints

`POST /topicos`: Cria um novo tópico e retorna os detalhes dele

`GET /topicos/{id}`: Apresenta os detalhes de um tópico

`GET /topicos`: Lista todos os tópicos.

`PUT /topicos/{id}`: Atualiza um tópico e retorna os detalhes dele

`DELETE /topicos/{id}`: Exclui um tópico

`POST /login`: Autentica o usuário e retorna um token de acesso


## Tecnologias Utilizadas

- **Spring Web:** Framework Java para desenvolvimento de aplicações web.
- **Java:** Linguagem de programação utilizada para desenvolver a aplicação.
- **Spring Data JPA:** Framework para acesso a dados com JPA.
- **MySQL:** Banco de dados relacional utilizado para armazenar os dados da aplicação.
- **Flyway:** Ferramenta para gerenciamento de migrações de banco de dados.
- **Spring Security:** Framework para segurança de aplicações web.
- **Maven:** Ferramenta para gerenciamento de dependências e construção do projeto.


## Como Executar o Projeto:

1. Clone o repositório:
    ```bash
    git clone https://github.com/Edisonepj/forum-hub.git
    ```
    
2. Entre no diretório do projeto
    ```bash
    cd forum-hub
    ```
    
3. Banco de dados:
    - Crie um banco de dados chamado **forum_hub**
    - Configure o banco de dados no arquivo `application.properties`
    - Importe as migrações do Flyway para o banco de dados

4. Execute a aplicação:

    Execute o comando `mvn springboot:run` na raiz do projeto.
   

## Observações:

- As credenciais de acesso ao banco de dados estão definidas no arquivo application.properties.
- A aplicação utiliza o Spring Security para autenticação e autorização.
- A documentação da API será gerada automaticamente pelo SpringDoc em breve e poderá ser acessada através do Swagger.

 