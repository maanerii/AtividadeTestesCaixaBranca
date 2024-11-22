# AtividadeTestesCaixaBranca
## ETAPA 4

- Login System - Java Project

Este projeto é um sistema básico de autenticação de usuários utilizando Java e um banco de dados MySQL. Ele contém uma classe principal chamada `User`, que gerencia a conexão com o banco de dados e realiza a validação de credenciais fornecidas.

 Estrutura do Projeto

O código consiste em uma única classe chamada `User`, que apresenta as seguintes funcionalidades principais:

- 1. **Conexão com o Banco de Dados**
     
O método `conectarBD()` é responsável por estabelecer a conexão com o banco de dados MySQL.  

- **Tecnologia utilizada:** JDBC (Java Database Connectivity).
- 
- **Função principal:** Retornar uma instância `Connection` para interação com o banco de dados.
- 
Se ocorrer algum erro, o método retorna `null`.


- 2. **Verificação de Credenciais**
     
O método `verificarUsuario(String login, String senha)` realiza a validação das credenciais fornecidas pelo usuário:

- Constrói e executa uma consulta SQL para verificar se o nome de usuário e a senha estão corretos.
- 
- Retorna `true` se o login for bem-sucedido, ou `false` caso contrário.
- 
- Armazena o nome do usuário autenticado na variável `nome` para uso posterior.
  

 **Dependências**

- **Java Development Kit (JDK):** Requerido para compilar e executar o código.
  
- **Driver JDBC do MySQL:** Necessário para comunicação com o banco de dados MySQL.
  
- **MySQL:** Banco de dados utilizado para armazenar os dados de login dos usuários.



