package org.example;

import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
//            Cadastro Cadastro = new Cadastro();
//            Cadastro.setVisible(true);
            Login login = new Login();
            login.setVisible(true);
//            Logo logo = new Logo();
//            logo.setVisible(true);
        });
    }
}