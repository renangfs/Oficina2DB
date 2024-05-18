package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estoque extends Login { // Mudando para JPanel
    Login login;
    JButton botaoVoltar;
    JButton botaoIncluirEntrada;
    JButton botaoincluirSaida;

    JPanel painelSuperiorEstoque;
//    JPanel painelTabelaEstoque;

    JLabel textoEstoque;

    public Estoque(Login login) {
        this.login = login;



        painelSuperiorEstoque = new JPanel(new GridBagLayout());
        painelSuperiorEstoque.setBackground(Color.WHITE);

        textoEstoque = new JLabel("Estoque");
        textoEstoque.setForeground(new Color(0, 0, 0));
        textoEstoque.setFont(new Font("Roboto", Font.BOLD, 30));

        botaoIncluirEntrada = new JButton("Incluir entrada  + ");
        botaoIncluirEntrada.setPreferredSize(new Dimension(120, 30));
        botaoIncluirEntrada.setBorder(new LineBorder(new Color(193, 193, 193)));
        botaoIncluirEntrada.setBackground(new Color(255, 255, 255));
        botaoIncluirEntrada.setForeground(new Color(200, 200, 200));
        botaoIncluirEntrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoincluirSaida = new JButton("Incluir Saída   - ");
        botaoincluirSaida.setPreferredSize(new Dimension(120, 30));
        botaoincluirSaida.setBorder(new LineBorder(new Color(193, 193, 193)));
        botaoincluirSaida.setBackground(new Color(255, 255, 255));
        botaoincluirSaida.setForeground(new Color(200, 200, 200));
        botaoincluirSaida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(100, 30));
        botaoVoltar.setBorder(new LineBorder(new Color(193, 193, 193)));
        botaoVoltar.setBackground(new Color(255, 255, 255));
        botaoVoltar.setForeground(new Color(200, 200, 200));
        botaoVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        painelSuperiorEstoque.add(botaoVoltar, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painelSuperiorEstoque.add(botaoIncluirEntrada, gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        painelSuperiorEstoque.add(botaoincluirSaida, gbc);
        gbc.gridy = 0;
        gbc.gridx = 2;
        painelSuperiorEstoque.add(textoEstoque, gbc);

        add(painelSuperiorEstoque);


        botaoVoltar.addActionListener(this::Voltar);
        botaoIncluirEntrada.addActionListener(this::IncluirEntrada);
        botaoincluirSaida.addActionListener(this::IncluirSaida);
    }

    public JPanel getPainelEstoque() {
        return painelSuperiorEstoque;
    }

    public void IncluirEntrada(ActionEvent e) {
        System.out.println("Clicou em incluir entrada");
        login.IncluirEntrada();
    }

    public void IncluirSaida(ActionEvent e) {
        System.out.println("Clicou em incluir Saida");
    }

    public void Voltar(ActionEvent actionEvent) {
        login.VoltarMenuConsulta();//
    }

}
