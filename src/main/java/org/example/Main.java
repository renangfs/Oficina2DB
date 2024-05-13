package org.example;

import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

//            Login login = new Login();
//            login.setVisible(true);
            MenuConsulta menuConsulta = new MenuConsulta();
            menuConsulta.setVisible(true);
//            Logo logo = new Logo(); teste de imagem
//            logo.setVisible(true);
        });
    }
}