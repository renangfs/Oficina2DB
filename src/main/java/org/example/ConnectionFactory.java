package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection recuperarConexao() {
        String url = "jdbc:mysql://34.31.153.165:3306/OFICINA";
        String user = "root";
        String password = "JQ6GZT@9r8QOU0Lc";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Erro ao tentar se conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try (Connection connection = recuperarConexao()) {
            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
