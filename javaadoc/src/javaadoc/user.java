package javaadoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe designada para realizar operações relacionadas ao login.
 * 
 * Esta classe estabelece a conexão com um banco de dados MySQL e 
 * valida as credenciais fornecidas pelos usuários.
 */
public class user {

    /**
     * Variável responsável por armazenar o nome do usuário autenticado.
     */
    public String nome = "";

    /**
     * Variável que indica o resultado da autenticação.
     * Retorna true se o login for bem-sucedido, ou false caso contrário.
     */
    public boolean result = false;

    /**
     * Método utilizado para conectar ao banco de dados MySQL.
     * 
     * @return Connection Retorna um objeto de conexão com o banco de dados.
     * Retorna null em caso de falha.
     */
    @SuppressWarnings("deprecation")
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Inicializa o driver do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            
            // Configura e realiza a conexão com o banco de dados usando a URL, usuário e senha
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } 
        catch (Exception e) {
            // Trata qualquer erro que ocorrer durante a conexão
            // e retorna null se a conexão não for bem-sucedida
        }
        return conn;
    }

    /**
     * Método responsável por validar o login e a senha de um usuário.
     * 
     * @param login O nome de usuário fornecido.
     * @param senha A senha fornecida.
     * @return boolean Retorna true se as credenciais forem válidas,
     * ou false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";

        // Constrói a consulta SQL para verificar as credenciais no banco
        sql += "select none from usuarios ";
        sql += "where login = " + " ' " + login + " ' ";
        sql += " and senha = " + " ' " + senha + " '; ";
        
        // Estabelece a conexão com o banco de dados
        Connection conn = conectarBD();
        
        try {
            // Cria um Statement para executar a instrução SQL
            Statement st = conn.createStatement();
            
            // Realiza a consulta no banco de dados
            ResultSet rs = st.executeQuery(sql);
            
            // Checa se a consulta retornou algum registro
            if (rs.next()) {
                // Login bem-sucedido
                result = true;
                
                // Recupera o nome do usuário
                nome = rs.getString("nome");
            }
        } 
        catch (Exception e) {
            // Trata quaisquer erros que ocorram durante a execução da consulta SQL
        }
        
        // Retorna o status da autenticação
        return result;
    }
} 
// Fim da classe
