package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Cadastro{
    JButton botaoCancelar;
    JButton botaoCadastrar;
    JPanel panelCadastro;
    Login login;

    public Cadastro(Login login) {
        this.login = login;
        panelCadastro = new JPanel(new GridBagLayout());
        panelCadastro.setBackground(Color.white);//muda a cor do painel

        JLabel textoChave = new JLabel("Chave de cadastro:");
        JLabel textoNome = new JLabel("Nome:");
        JLabel textoCpf = new JLabel("CPF:");
        JLabel textoTelefone = new JLabel("Telefone:");
        JLabel textoEmail = new JLabel("Email:");
        JLabel textoSenha = new JLabel("Senha:");

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

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        // y = Baixo  x = Direita
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 5, 5, 235);
        panelCadastro.add(textoChave, gbc);

        gbc.insets = new Insets(0, 5, 40, 100);
        gbc.gridy = 1;
        panelCadastro.add(campoChave, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 30, 40, 5);
        panelCadastro.add(botaoAplicar, gbc);

        gbc.insets = new Insets(0, 8, 3, 5);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCadastro.add(textoNome, gbc);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 8, 10, 5);
        panelCadastro.add(campoNome, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 8, 3, 5);
        gbc.gridy = 4;
        panelCadastro.add(textoCpf, gbc);
        gbc.gridx = 1;
        panelCadastro.add(textoTelefone, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 8, 10, 5);
        panelCadastro.add(campoCPF, gbc);
        gbc.gridx = 1;
        panelCadastro.add(campoTelefone, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 8, 3, 5);
        panelCadastro.add(textoEmail, gbc);
        gbc.gridx = 1;
        panelCadastro.add(textoSenha, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        panelCadastro.add(campoEmail, gbc);
        gbc.gridx = 1;
        panelCadastro.add(campoSenha, gbc);

        gbc.insets = new Insets(40, 20, 5, 5);
        gbc.gridy = 8;
        panelCadastro.add(botaoCancelar, gbc);
        gbc.insets = new Insets(40, 120, 5, 5);
        panelCadastro.add(botaoCadastrar, gbc);

        botaoCancelar.addActionListener(this::Cancelar);
        botaoCadastrar.addActionListener(this::Cadastrar);
    }

    public JPanel getPanelCadastro() {
        return panelCadastro;
    }

    public void Cancelar(ActionEvent e) {
        login.voltarLogin();
    }

    public void Cadastrar(ActionEvent e){
        System.out.println("Cadastrar");
    }
}
