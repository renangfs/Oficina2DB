package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    JButton botaoLogin;
    JButton botaoCadastrar;

    public Login() {

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.white);//muda a cor do painel

        JLabel textoLogin = new JLabel("Login:");
        JLabel textoSenha = new JLabel("Senha:");
        JLabel esqueciSenha = new JLabel("Esqueci minha senha");

        JTextField campoLogin = new JTextField();
        campoLogin.setPreferredSize(new Dimension(300, 25));
        JTextField campoSenha = new JTextField();
        campoSenha.setPreferredSize(new Dimension(300, 25));

        botaoLogin = new JButton("Entrar");
        botaoLogin.setPreferredSize(new Dimension(300, 30));

        botaoCadastrar = new JButton("Cadastre-se  ");
        botaoCadastrar.setPreferredSize(new Dimension(300, 30));

        setSize(1200,800);//Tamanho de abertura
        setMinimumSize(new Dimension(1200,800));//Tamanho mínimo da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Quando fechar a janela o programa vai ser encerrado
        setLocationRelativeTo(null);//Centraliza a janela

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;


        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        painel.add(textoLogin, gbc);

        gbc.insets = new Insets(0, 5, 20, 5);
        gbc.gridy = 1;
        painel.add(campoLogin, gbc);

        gbc.insets = new Insets(0, 5, 5, 5);
        gbc.gridy = 2;
        painel.add(textoSenha, gbc);

        gbc.gridy = 3;
        painel.add(campoSenha, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(0, 5, 20, 5);
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        painel.add(esqueciSenha, gbc);

        gbc.insets = new Insets(0, 5, 15, 5);
        gbc.gridy = 5;
        painel.add(botaoLogin, gbc);

        gbc.gridy = 6;
        painel.add(botaoCadastrar, gbc);

        add(painel, BorderLayout.CENTER);

        botaoCadastrar.addActionListener(this::Cadastrar);
        botaoLogin.addActionListener(this::Logar);

    }
    public void Cadastrar(ActionEvent e) {
        System.out.println("Clicando cadastrar");
    }
    public void Logar(ActionEvent e) {
        System.out.println("Clicando logar");
    }
}