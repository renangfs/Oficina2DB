package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuConsulta extends JFrame {
    JButton botaoEstoque;
    JButton botaoEntradas;
    JButton botaoSaidas;
    JButton botaoSair;

    JPanel painelConsulta;

    JLabel textoConsultar;

    public MenuConsulta() {
        setSize(1200, 800); // largura e altura da janela
        setMinimumSize(new Dimension(1200, 800)); // largura e altura minima da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // configurando o encerramento do programa ao fechar
        setLocationRelativeTo(null); // centraliza a janela


        textoConsultar = new JLabel("Consultar");
        textoConsultar.setForeground(new Color(0, 0, 0));
        textoConsultar.setFont(new Font("Roboto", Font.BOLD, 40));

        painelConsulta = new JPanel(new GridBagLayout());
        painelConsulta.setBackground(Color.WHITE);

        botaoEstoque = new JButton("Estoque");
        botaoEstoque.setPreferredSize(new Dimension(300, 40));
        botaoEstoque.setBorder(new LineBorder(new Color(234, 234, 234)));
        botaoEstoque.setBackground(new Color(234, 234, 234));
        botaoEstoque.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoEntradas = new JButton("Entradas");
        botaoEntradas.setPreferredSize(new Dimension(300, 40));
        botaoEntradas.setBorder(new LineBorder(new Color(234, 234, 234)));
        botaoEntradas.setBackground(new Color(234, 234, 234));
        botaoEntradas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoSaidas = new JButton("Saidas");
        botaoSaidas.setPreferredSize(new Dimension(300, 40));
        botaoSaidas.setBorder(new LineBorder(new Color(234, 234, 234)));
        botaoSaidas.setBackground(new Color(234, 234, 234));
        botaoSaidas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoSair = new JButton("Sair");
        botaoSair.setPreferredSize(new Dimension(100, 30));
        botaoSair.setBorder(new LineBorder(new Color(193, 193, 193)));
        botaoSair.setBackground(new Color(255, 255, 255));
        botaoSair.setForeground(new Color(200, 200, 200));
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

    }


    private void voltarLogin(ActionEvent actionEvent) {
        System.out.println("Voltando para o login");
    }

    public void Estoque(ActionEvent e) {
        System.out.println("Clicando em esqueci senha");
    }

    public void Entrada(ActionEvent e) {
        System.out.println("Clicando em cadastrar");
    }

    public void Saidas(ActionEvent e) {
        System.out.println("Clicando em logar");
    }

}
