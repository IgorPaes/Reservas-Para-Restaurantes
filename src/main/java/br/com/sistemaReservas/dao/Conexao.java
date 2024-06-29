package br.com.sistemaReservas.dao;

import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class Conexao {

    public static String STATUS = "Não conectado";
    public static Connection CONEXAO;

    public static Connection abrirConexao() throws ClassNotFoundException,SQLException {

        if(CONEXAO==null) {

            try {
                CONEXAO = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                    log.info("Conectado com sucesso");
                } else {
                    STATUS = "Não foi possível realizar a conexão";
                    log.error("falha na conexão ");
                }

            } catch (SQLException e) {
                throw new SQLException("Erro ao estabelecer a conexão.");
            }

        } else {
            try {
                if(CONEXAO.isClosed())
                    CONEXAO = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            } catch (SQLException ex) {
                throw new SQLException("Falha ao fechar a conexão.");
            }
        }
        return CONEXAO;
    }

    public static String getStatusConexao() {
        return STATUS;
    }

    public static boolean fecharConexao() throws SQLException {

        boolean retorno = false;

        try {
            if(CONEXAO!=null){
                if(!CONEXAO.isClosed())
                    CONEXAO.close();
            }

            STATUS = "Não conectado";
            retorno = true;

        } catch (SQLException e) {
            retorno = false;
        }

        return retorno;
    }
    
}
