package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuConsulta extends Login {
    JButton botaoEstoque;
    JButton botaoEntradas;
    JButton botaoSaidas;
    JButton botaoSair;
    Login login;

    JPanel painelConsulta;

    JLabel textoConsultar;

    public MenuConsulta(Login login) {
        this.login = login;

        textoConsultar = new JLabel("Consultar");
        textoConsultar.setForeground(new Color(0, 0, 0));
        textoConsultar.setFont(new Font("Roboto", Font.BOLD, 30));

        painelConsulta = new JPanel(new GridBagLayout());
        painelConsulta.setBackground(Color.WHITE);

        botaoEstoque = new JButton("Estoque");
        botaoEstoque.setFont(new Font("Roboto", Font.BOLD, 15));
        botaoEstoque.setPreferredSize(new Dimension(300, 40));
        botaoEstoque.setBorder(new LineBorder(new Color(234, 234, 234)));
        botaoEstoque.setBackground(new Color(234, 234, 234));
        botaoEstoque.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoEntradas = new JButton("Entradas");
        botaoEntradas.setFont(new Font("Roboto", Font.BOLD, 15));
        botaoEntradas.setPreferredSize(new Dimension(300, 40));
        botaoEntradas.setBorder(new LineBorder(new Color(234, 234, 234)));
        botaoEntradas.setBackground(new Color(234, 234, 234));
        botaoEntradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoSaidas = new JButton("Saidas");
        botaoSaidas.setFont(new Font("Roboto", Font.BOLD, 15));
        botaoSaidas.setPreferredSize(new Dimension(300, 40));
        botaoSaidas.setBorder(new LineBorder(new Color(234, 234, 234)));
        botaoSaidas.setBackground(new Color(234, 234, 234));
        botaoSaidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoSair = new JButton("Sair");
        botaoSair.setPreferredSize(new Dimension(100, 30));
        botaoSair.setBorder(new LineBorder(new Color(193, 193, 193)));
        botaoSair.setBackground(new Color(255, 255, 255));
        botaoSair.setForeground(new Color(180, 180, 180));
        botaoSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 5, 30, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        painelConsulta.add(textoConsultar, gbc);

        gbc.insets = new Insets(0, 5, 30, 5);
        gbc.gridy = 1;
        painelConsulta.add(botaoEstoque, gbc);

        gbc.insets = new Insets(0, 5, 30, 5);
        gbc.gridy = 2;
        painelConsulta.add(botaoEntradas, gbc);

        gbc.insets = new Insets(0, 5, 30, 5);
        gbc.gridy = 3;
        painelConsulta.add(botaoSaidas, gbc);

        gbc.insets = new Insets(0, 5, 40, 5);
        gbc.gridy = 4;
        painelConsulta.add(botaoSair, gbc);

        add(painelConsulta);

        botaoEstoque.addActionListener(this::Estoque);
        botaoEntradas.addActionListener(this::Entrada);
        botaoSaidas.addActionListener(this::Saidas);
        botaoSair.addActionListener(this::VoltarLogin);

    }

    private void Estoque(ActionEvent actionEvent) {
        login.Estoque();//indo para a classe login...para ir para classe estoque
    }


    public void Entrada(ActionEvent e) {
        System.out.println("Clicando em entrada");
    }

    public void Saidas(ActionEvent e) {
        System.out.println("Clicando em saida");
    }

    private void VoltarLogin(ActionEvent actionEvent) {
        login.VoltarLogin();
    }

}
