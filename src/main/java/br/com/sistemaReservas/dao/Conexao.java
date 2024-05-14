package br.com.sistemaReservas.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {
    public static String STATUS = "Não conectado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String SERVER = "localhost";
    public static String DATABASE = "sistema_reserva";
    public static String LOGIN = "root";
   //public static String SENHA = "P@$$w0rd";
    //senha andre
   //public static String SENHA = "210215";
    public static String SENHA = "sa";
    public static String URL = "jdbc:mysql://" + SERVER + ":3306/" + DATABASE;
    public static Connection CONEXAO;
    public Conexao() {}
    public static Connection abrirConexao() throws ClassNotFoundException,SQLException {

        if(CONEXAO==null) {
            try {

                Class.forName(DRIVER);
                 CONEXAO = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                //CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);

                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                    System.out.println("Conectado com sucesso");
                } else {
                    STATUS = "Não foi possivel realizar a conexão";
                    System.out.println("falha na conexão ");
                }

            } catch (ClassNotFoundException e) {

                throw new ClassNotFoundException("O driver expecificado nao foi encontrado.");

            } catch (SQLException e) {

                //Outra falha de conexão
                throw new SQLException("Erro ao estabelecer a conexão (Ex: login ou senha errados).");
            }

        }
        else
        {
            try {
                if(CONEXAO.isClosed())
                    //CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
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
