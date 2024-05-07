package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static void main(String... x) {

        try{
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/oficina", "root", "");
            System.out.println("Recuperei a conexão");

            connection.close();
        }catch(SQLException e){
            System.out.println(e);
        }

    }
}
