package org.example;

import javax.swing.*;
import java.awt.*;

public class Cadastro extends JFrame {
    public Cadastro(){

        setSize(1200,800);//Tamanho de abertura
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1200,800));//Tamanho mínimo da janela
        setLocationRelativeTo(null);

        JLabel textoChave = new JLabel("Chave de cadastro:");
        JLabel textoNome = new JLabel("Nome:");
        JLabel textoCpf = new JLabel("CPF:");
        JLabel textoTelefone = new JLabel("Telefone:");
        JLabel textoEmail = new JLabel("Email:");
        JLabel textoSenha = new JLabel("Senha:");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);//muda a cor do painel


        JTextField campoChave = new JTextField();
        campoChave.setPreferredSize(new Dimension(250, 25));

        JButton botaoAplicar = new JButton("Aplicar");
        botaoAplicar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)

        JTextField campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(415, 25));


        JTextField campoCPF = new JTextField();
        campoCPF.setPreferredSize(new Dimension(200, 25));

        JTextField campoTelefone = new JTextField();
        campoTelefone.setPreferredSize(new Dimension(200, 25));

        JTextField campoEmail = new JTextField();
        campoEmail.setPreferredSize(new Dimension(200, 25));

        JTextField campoSenha = new JTextField();
        campoSenha.setPreferredSize(new Dimension(200, 25));

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        // y = Baixo  x = Direita
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 5, 5, 235);
        panel.add(textoChave, gbc);


        gbc.insets = new Insets(0, 5, 40,100);
        gbc.gridy = 1;
        panel.add(campoChave, gbc);
        gbc.gridx = 1;//direita
        gbc.insets = new Insets(0, 30, 40, 5);
        panel.add(botaoAplicar, gbc);

        gbc.insets = new Insets(0, 8, 3, 5);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = 2;
        gbc.gridx = 0;//direita
        gbc.gridy = 2;
        panel.add(textoNome, gbc);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 8, 10, 5);
        panel.add(campoNome, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 8, 3, 5);
        gbc.gridy = 4;
        panel.add(textoCpf, gbc);
        gbc.gridx = 1;
        panel.add(textoTelefone, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 8, 10, 5);
        panel.add(campoCPF, gbc);
        gbc.gridx = 1;
        panel.add(campoTelefone, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 8, 3, 5);
        panel.add(textoEmail, gbc);
        gbc.gridx = 1;
        panel.add(textoSenha, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(campoEmail, gbc);
        gbc.gridx = 1;
        panel.add(campoSenha, gbc);

        gbc.insets = new Insets(40, 20, 5, 5);
        gbc.gridy = 8;//direita
        panel.add(botaoCancelar, gbc);
        gbc.insets = new Insets(40, 120, 5, 5);
        panel.add(botaoCadastrar, gbc);


        add(panel, BorderLayout.CENTER);
    }
}
