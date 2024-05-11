package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Cadastro{
    JButton botaoCancelar;
    JButton botaoCadastrar;
    JPanel panelCadastro;
    Login login;

    JTextField campoChave;
    JTextField campoNome;
    JTextField campoCPF;
    JTextField campoTelefone;
    JTextField campoEmail;
    JTextField campoSenha;

    JLabel textoChave;

    JButton botaoAplicar;

    public Cadastro(Login login) {
        this.login = login;
        panelCadastro = new JPanel(new GridBagLayout());
        panelCadastro.setBackground(Color.white);//muda a cor do painel

        textoChave = new JLabel("Chave de cadastro:");
        textoChave.setForeground(new Color(118, 118, 118));
        textoChave.setFont(new Font("Roboto", Font.BOLD, 12));
        JLabel textoNome = new JLabel("Nome:");
        textoNome.setForeground(new Color(118, 118, 118));
        textoNome.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoCpf = new JLabel("CPF:");
        textoCpf.setForeground(new Color(118, 118, 118));
        textoCpf.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoTelefone = new JLabel("Telefone:");
        textoTelefone.setForeground(new Color(118, 118, 118));
        textoTelefone.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoEmail = new JLabel("Email:");
        textoEmail.setForeground(new Color(118, 118, 118));
        textoEmail.setFont(new Font("Roboto", Font.PLAIN, 12));
        JLabel textoSenha = new JLabel("Senha:");
        textoSenha.setForeground(new Color(118, 118, 118));
        textoSenha.setFont(new Font("Roboto", Font.PLAIN, 12));

        campoChave = new JTextField();
        campoChave.setPreferredSize(new Dimension(250, 25));

        botaoAplicar = new JButton("Aplicar");
        botaoAplicar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoAplicar.setBackground(new Color(0, 30, 253));
        botaoAplicar.setForeground(new Color(255, 255, 255));
        botaoAplicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(415, 25));
        campoNome.setEnabled(false);

        campoCPF = new JTextField();
        campoCPF.setPreferredSize(new Dimension(200, 25));
        campoCPF.setEnabled(false);

        campoTelefone = new JTextField();
        campoTelefone.setPreferredSize(new Dimension(200, 25));
        campoTelefone.setEnabled(false);

        campoEmail = new JTextField();
        campoEmail.setPreferredSize(new Dimension(200, 25));
        campoEmail.setEnabled(false);

        campoSenha = new JTextField();
        campoSenha.setPreferredSize(new Dimension(200, 25));
        campoSenha.setEnabled(false);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoCancelar.setForeground(new Color (118, 118, 118));
        botaoCancelar.setBackground(new Color (255, 255, 255));
        botaoCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(50, 50, 100, 30); // (x, y, largura, altura)
        botaoCadastrar.setForeground(new Color (230, 230, 230));
        botaoCadastrar.setBackground(new Color (255, 255, 255));
        botaoCadastrar.setEnabled(false);
        botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


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
        gbc.insets = new Insets(0, 50, 40, 5);
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

        botaoAplicar.addActionListener(this::Aplicar);
        botaoCancelar.addActionListener(this::Cancelar);
        botaoCadastrar.addActionListener(this::Cadastrar);
    }

    public JPanel getPanelCadastro() {
        return panelCadastro;
    }

    public void Cancelar(ActionEvent e) {
        login.voltarLoginCadastro();
    }
    public void Aplicar(ActionEvent e) {
        if (Objects.equals(campoChave.getText(), "123")) {

            botaoAplicar.setForeground(new Color (184, 207, 229));
            botaoAplicar.setBackground(new Color (255, 255, 255));

            botaoCadastrar.setBackground(new Color(0, 30, 253));
            botaoCadastrar.setForeground(new Color(255, 255, 255));

            botaoAplicar.setEnabled(false);
            campoChave.setEnabled(false);
            botaoCadastrar.setEnabled(true);
            campoNome.setEnabled(true);
            campoCPF.setEnabled(true);
            campoTelefone.setEnabled(true);
            campoEmail.setEnabled(true);
            campoSenha.setEnabled(true);

            JOptionPane.showMessageDialog(null, "Chave aplicada com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Chave incorreta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void Cadastrar(ActionEvent e) {
        try (Connection connection = ConnectionFactory.recuperarConexao()) {
            String sql = "INSERT INTO funcionario (nome, cpf, telefone, email, senha) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, campoNome.getText());
            statement.setString(2, campoCPF.getText());
            statement.setString(3, campoTelefone.getText());
            statement.setString(4, campoEmail.getText());
            statement.setString(5, campoSenha.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            login.voltarLoginCadastro(); // Voltar para a tela de login após cadastrar
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + ex.getMessage());
        }

    }
}