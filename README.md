### ETAPA 1 - Aponte os erros que podem conter no código e crie um Readme explicando os erros encontrados.
- 1 Erro = Ocorre porque o código fornecido não contém um método main() (Linha 8)
  
Problema: Could not find or load main class User.
Explicação: O código fornecido não possue uma classe Main.

- 2 Erro = Uso de "com.mysql.jdbc.Driver" (Linha 12)
  
Problema: A classe `com.mysql.jdbc.Driver` está desatualizada, e o método newInstance(), está antiquado.
Explicação: Desde a versão do Java 9, o método newInstace() não é mais utilizado.

- 3 Erro = Exposição de Credenciais no Código (Linha 12)
  
Problema: A URL de conexão inclui credenciais (`user=lopes&password=123`) diretamente no código, o que representa um risco de segurança, pois expõe informações sensíveis.
Explicação: A URL não está exatamente errada, porém, é uma forma ultrapassada de fazer a conexão com o banco de dados. O username e password são passados como parâmetros separados ao método getConnection(), o que melhora a segurança e separação de responsabilidades.

- 4 Erro = Conexão Retornando `null` em Caso de Falha (Linha 15)
  
Problema: Se a conexão falhar, o método `conectarBD()` retorna `null`, o que pode causar uma `NullPointerException` quando `conn.createStatement()` for chamado.
Explicação: Adicione um tratamento de erro adequado e retorne uma mensagem ou lance uma exceção personalizada.

- 4 Erro = SQL Injection (Linhas 21–25)
  
Problema: Consulta resultando em SQLException.
Explicação: A query tenta buscar uma coluna chamada "none", porém esta coluna é inexistente.
  
- 5 Erro = Manuseio Inadequado de Exceções (Linhas 14 e 30)
  
Problema: Os blocos `catch` capturam exceções, mas não as registram ou as exibem, dificultando a depuração.
Explicação: Adicione um `e.printStackTrace();` ou registre a exceção usando um logger para facilitar a identificação de erros.

- 6 Erro = Consulta possui espaços extras (Linha 29)
  
Problema: A consulta SQL concatenada na linha 29 possui espaços extras dentro das aspas simples. A forma de concatenar as strings resulta em uma consulta inválida ou mal formatada, o que pode causar um SQLException ao tentar executá-la.
Explicação: A inclusão de espaços dentro das aspas simples para os valores de login e senha não só afeta a sintaxe da consulta, como também pode tornar o código mais suscetível a erros de formatação.

- 7 Erro = Consulta possui espaços extras (Linha 30)
  
Problema: Assim como no erro anterior, a consulta concatenada na linha 30 também possui espaços extras dentro das aspas simples. Isso pode gerar uma consulta malformada, que resultaria em erro durante a execução.
Explicação: Os espaços extras não são necessários e podem interferir na estrutura do SQL, além de tornarem o código mais propenso a falhas.

- 8 Erro = Exceção não tratada e SQL Injection (Linha 31)
  
Problema: O bloco catch no código não trata exceções corretamente, o que pode fazer com que erros de banco de dados passem despercebidos. Além disso, a concatenação direta de strings para formar consultas SQL é vulnerável a SQL Injection, colocando a segurança do sistema em risco.
Explicação: O uso de concatenação de strings para montar consultas SQL é uma prática insegura, pois permite que um usuário mal-intencionado insira comandos SQL maliciosos. Além disso, a falta de tratamento adequado das exceções impede que erros sejam registrados ou tratados corretamente, dificultando a identificação de problemas.

- 9 Erro = Fechamento de Recursos (Linhas 27–30)
  
Problema: O código não fecha os recursos (`Connection`, `Statement`, `ResultSet`), o que pode levar a vazamentos de memória.
Explicação: Use o bloco `try-with-resources` para garantir que os recursos sejam fechados automaticamente:

10 - Inicialização da Variável `nome` e `result` (Linhas 17–18)

Problema: As variáveis `nome` e `result` são declaradas como variáveis de instância, mas poderiam ser variáveis locais dentro do método `verificarUsuario` para evitar possíveis problemas de concorrência em um ambiente multithread.
Explicação: Declare `nome` e `result` dentro do método `verificarUsuario`.
