### ETAPA 1 - Aponte os erros que podem conter no código e crie um Readme explicando os erros encontrados.
// O Arquivo login.java é o código incorreto fornecido para a atividade.
- 1 Erro = Ocorre porque o código fornecido não acha o User (Linha 8)
  
Problema: Could not find or load main class User.

Explicação: O código fornecido não possue uma classe Main.


- 2 Erro = Uso de "com.mysql.jdbc.Driver" (Linha 12)
  
Problema: A classe `com.mysql.jdbc.Driver` está desatualizada, e o método newInstance(), está antiquado.

Explicação: Desde a versão do Java 9, o método newInstace() não é mais utilizado.


- 3 Erro = Exposição de Credenciais no Código (Linha 12-14)
  
Problema: A URL de conexão inclui credenciais (`user=lopes&password=123`) diretamente no código, o que representa um risco de segurança, pois expõe informações sensíveis.

Explicação: A URL não está exatamente errada, porém, é uma forma ultrapassada de fazer a conexão com o banco de dados. O username e password são passados como parâmetros separados ao método getConnection(), o que melhora a segurança e separação de responsabilidades.



- 4 Erro = (Linhas 16 e 28)
  
Problema: Consulta resultando em SQLException e depois não trata a exceção

Explicação: A query tenta buscar uma coluna chamada "none", porém esta coluna é inexistente.

  
- 5 Erro = Manuseio Inadequado de Exceções (Linhas 14 e 30)
  
Problema: Os blocos `catch` capturam exceções, mas não as registram ou as exibem, dificultando a depuração.

Explicação: Adicione um `e.printStackTrace();` ou registre a exceção usando um logger para facilitar a identificação de erros.


- 6 Erro: Linha 29.
  
Problema: Consulta possui espaços extras.

Explicação: A cosulta sql += "where login = " + " ' " + login + " ' "; possui espaços extras dentro das aspas simples, o que pode resultar em uma consulta inválida resultando em um SQLException.


- 7 Erro = Linha 30:

Problema: Consulta possui espaços extras.

Explicação: A cosulta sql += " and senha = " + " ' " + senha + " '; "; possui espaços extras dentro das aspas simples, o que pode resultar em uma consulta inválida resultando em um SQLException.



- 8 Erro = Exceção não tratada e SQL Injection
  
Problema: O bloco catch no código não trata exceções corretamente, o que pode fazer com que erros de banco de dados passem despercebidos. Além disso, a concatenação direta de strings para formar consultas SQL é vulnerável a SQL Injection, colocando a segurança do sistema em risco.

Explicação: O uso de concatenação de strings para montar consultas SQL é uma prática insegura, pois permite que um usuário mal-intencionado insira comandos SQL maliciosos. Além disso, a falta de tratamento adequado das exceções impede que erros sejam registrados ou tratados corretamente, dificultando a identificação de problemas.

- 9 Erro = Fechamento de Recursos (Linhas 27–30)
  
Problema: O código não fecha os recursos (`Connection`, `Statement`, `ResultSet`), o que pode levar a vazamentos de memória.

Explicação: Use o bloco `try-with-resources` para garantir que os recursos sejam fechados automaticamente:

// Após corrigir tudo, o novo código está no Arquivo User.java

### ETAPA 2 - ARQUIVO DO PLANO DE TESTE DE CAIXA BRANCA NO REPOSITÓRIO.
Arquivo do Plano de Teste já foi realizado e publico na Branch: Main

### ETAPA 03 - GRAFO DE FLUXO, COMPLEXIDADE CICLOMÁTICA E BASE DE CAMINHO


