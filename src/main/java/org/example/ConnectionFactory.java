package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection recuperarConexao() {
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://35.199.78.153:3306/oficina", "root", "b2Y74Sk`kC,$leH#");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}